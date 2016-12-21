
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

function GetSMUrls ($hostnames)
{ 
  $smurls = @()
  foreach($hostname in $hostnames)
  {
     $smurls += "\\"+$hostname+"\drived\data\servicemanager\"
  }
  return $smurls
}

function replaceService ($filename, $findStr, $targetStr)
{
    if ([System.IO.File]::Exists($filename)) {
        $Content = Get-Content $filename
        $cstring = $Content|out-string
        if ($cstring.IndexOf($findStr) -ne -1){
          foreach ($line in $Content){
            if($line.StartsWith($findStr)){
               $Content=$Content.Replace($line,$targetStr)
            }
           }
           $Content|Out-File -Encoding ascii $filename
        }
        else
        {
            Write-Error "can not find string"
        }
    }
    else
    {
      Write-Error "Config file `"$filename`" doesnot exist!"
    }
}

$SMUrls = GetSMUrls (Get-Hostnames D:\app\MachineList.csv)

foreach($smurl in $SMUrls){
    #replaceService $smurl"servicelist_override.ini" "Yarn_NodeManager.Yarn20150630_v4106767" ";;;;Yarn_NodeManager.Yarn20150630_v4106767"
}
foreach($smurl in $SMUrls){
    replaceService $smurl"servicelist_override.ini" ";;;;Yarn_NodeManager.Yarn20150630_v4106767" "Yarn_NodeManager.Yarn20150630_v4106767 ="
}

foreach($smurl in $SMUrls){
   #copy -Recurse -Force D:\data\servicemanager\servicelist_override.ini $smurl
}

