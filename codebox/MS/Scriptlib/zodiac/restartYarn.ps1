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
           if($items[$index].Trim().Equals("YarnRM1") -or $items[$index].Trim().Equals("YarnRM2") -or $items[$index].Trim().Equals("IS") ){
                $list+=$items[0]
           }
         }
    }
    return $list
  }

  Write-Error "Config file `"$filename`" doest exist!"
  return $null
}



function RestartYarnService($hostname){
  $process = "java.exe"
  $processContent=Get-WmiObject Win32_Process -computername $hostname -Filter "name = '$process'" 

  foreach($item in $processContent){
     $str=$item.CommandLine;
     if($str.IndexOf("ResourceManager") -ne -1){
         taskkill /pid $item.Handle /s $hostname /f
         Sleep(30)
     }
     elseif ($str.IndexOf("NodeManager") -ne -1){
         taskkill /pid $item.Handle /s $hostname /f
     }
  }
}

foreach($hostname in Get-Hostnames D:\app\MachineList.csv)
{
   RestartYarnService($hostname)
}