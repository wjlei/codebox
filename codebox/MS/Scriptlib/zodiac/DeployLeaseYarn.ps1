
function Get-Hostnames ($filename)
{
  if ([System.IO.File]::Exists($filename)) {
    $list = @() #map @{}
    $Content = Get-Content $filename
    $index = -1
    $SUnit = -1
    foreach ($line in $Content){
        if (($line.Length -gt 0) -and ($line.StartsWith("#Fields"))) {
            $items = $line -split ","
            $i = 0
            foreach ($item in $items){
               if($item.Trim().Equals("MachineFunction")){
                   $index = $i
               }
               elseif($item.Trim().Equals("ScaleUnit")){
                   $SUnit = $i
               }
               $i = $i+1
            }
         }
         elseif (($line.Length -gt 0) -and (!$line.StartsWith("#"))){
           $items = $line.Split(',')
           if(($items[$index].Trim().Equals("IS")) -and($items[$SUnit].Trim().Equals("201")) ){
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

function ReplaceOldConf()
{
  $SMUrls = GetSMUrls (Get-Hostnames D:\app\MachineList.csv)
  foreach($smurl in $SMUrls){
   if([System.IO.File]::Exists($smurl+"servicelist_override.ini")){ 
      $content = Get-Content($smurl+"servicelist_override.ini")
      $contentold = Get-Content("servicelist_override_old.ini")
      $contentnew = Get-Content("servicelist_override.ini")
      if(!(Compare-Object $content $contentold)){
         copy -Recurse -Force servicelist_override.ini $smurl
         write $smurl+" update the service_override."
      }
      elseif(!(Compare-Object $content $contentnew)){
         continue
      }
      else{
         write $smurl+" need update manually."
      }
    }
  }
}

#ReplaceOldConf

#$hostnames=Get-Hostnames D:\app\MachineList.csv
#foreach($hostname in $hostnames){
#  taskkill /im Microsoft.Search.Zodiac.Slave.exe /s $hostname /f
#}

#taskkill /im Microsoft.Search.Zodiac.Slave.exe /s co4sch010141106 /f

#copy -Recurse -Force .\ZodiacLeaseSlave "\\co4sch010141106\drived\app\"


#Sleep(10)

#$hostnames=Get-Hostnames D:\app\MachineList.csv
#foreach($hostname in $hostnames){
#  taskkill /im Microsoft.Search.Zodiac.Slave.exe /s $hostname /f
#}

#Sleep(10)

#$hostnames=Get-Hostnames D:\app\MachineList.csv
#foreach($hostname in $hostnames){
#  taskkill /im Microsoft.Search.Zodiac.Slave.exe /s $hostname /f
#}


$Urls = GetAppUrls (Get-Hostnames D:\app\MachineList.csv)
foreach($url in $Urls){
    copy -Recurse -Force D:\app\Yarn_NodeManager.test_zhmi $url
}

$SMUrls = GetSMUrls (Get-Hostnames D:\app\MachineList.csv)
foreach($smurl in $SMUrls){
   if(![System.IO.File]::Exists($smurl+"servicelist_override.ini")){ 
    copy -Recurse -Force D:\data\servicemanager\servicelist_override.ini $smurl
    }
    else{
       $content = Get-Content($smurl+"servicelist_override.ini")
       if ($content.Contains("ZodiacLeaseSlave=0")){
          write $smurl+" already contain zodiacLeasecSlave Serve"
       }
       else{
          write $smurl+" need add zodiacLeaseSlave Serve"
       }
    }
}

#$hostnames=Get-Hostnames D:\app\MachineList.csv
#foreach($hostname in $hostnames){
#  taskkill /im Microsoft.Search.Zodiac.Slave.exe /s $hostname /f
#}