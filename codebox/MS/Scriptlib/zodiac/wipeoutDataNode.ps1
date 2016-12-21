
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
           if($items[$index].Trim().Equals("IS") ){
                $list+=$items[0]
           }
         }
    }
    return $list
  }

  Write-Error "Config file `"$filename`" doest exist!"
  return $null
}

function GetAppUrls ($hostnames)
{ 
  $urls = @()
  foreach($hostname in $hostnames)
  {
     $urls += "\\"+$hostname+"\drived\app\"
  }
  return $urls
}

function GetSMUrls ($hostnames)
{ 
  $smurls = @()
  foreach($hostname in $hostnames)
  {
     $smurls += "\\"+$hostname+"\drived\data\servicemanager\"
  }
  return $smurls
}

$hostnames=Get-Hostnames D:\app\MachineList.csv
foreach($hostname in $hostnames){
  $hostpath="\\"+ $hostname
  start-process psexec  -ArgumentList "-s $hostpath cmd.exe /c rd/s/q D:\data\hdfs"
}