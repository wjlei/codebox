function Get-Hostnames ($filename)
{
  if ([System.IO.File]::Exists($filename)) {
    $list = @() #map @{}
    $Content = Get-Content $filename
    $index = -1
    foreach ($line in $Content){
        if (($line.Length -gt 0) -and ($line.StartsWith("#Fields"))) {
            $items = $line -split ","
            $i = 0
            foreach ($item in $items){
               if($item.Trim().Equals("MachineFunction")){
                   $index = $i
                   break
               }
               $i = $i+1
            }
         }
         elseif (($line.Length -gt 0) -and (!$line.StartsWith("#"))){
           $items = $line.Split(',')
           $list+=$items[0]
         }
    }
    return $list
  }

  Write-Error "Config file `"$filename`" doest exist!"
  return $null
}

function FigureOutTroubleMachine($filename)
{
  
    $list = @() #map @{}
    $Content = Get-Content $filename
    $index = -1
    foreach ($line in $Content){
        if (($line.Length -gt 0) -and ($line.StartsWith("PATH=D")) -and ($line.EndsWith('" /m')) ) {
           Write $filename
           $hostname=$filename.Substring(2,15)
           if(! $hostnameSet.Contains($hostname)){
               $hostname | Out-File result.txt -NoClobber -Append
               $hostnameSet.Add($hostname)
           }
         }
    }
  


}

$hostnameSet = New-Object System.Collections.Generic.HashSet[string]

function AnalysisPerMachine($hostname){
  $serviceoutput="\\"+$hostname+"\drived\data\serviceoutput"
  Get-ChildItem  $serviceoutput\Yarn_Java*.out | ForEach-Object -Process{
        FigureOutTroubleMachine($serviceoutput+"\"+$_.name)
  }
}

foreach($hostname in Get-Hostnames D:\app\MachineList.csv)
{
   AnalysisPerMachine($hostname)
}