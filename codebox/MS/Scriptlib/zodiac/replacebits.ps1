$hostnames = "cy2sch010130419","cy2sch010130615","cy2sch010130220","cy2sch010130123","cy2sch010130612","cy2sch010130614","cy2sch010130113","cy2sch010130421","cy2sch010130423",
"cy2sch010130122","cy2sch010130415","cy2sch010130215","cy2sch010130618","cy2sch010130510","cy2sch010130514","cy2sch010130611","cy2sch010130115","cy2sch010130121","cy2sch010130214",
"cy2sch010130216","cy2sch010130515","cy2sch010130212","cy2sch010130512","cy2sch010130517","cy2sch010130416","cy2sch010130126","cy2sch010130125","cy2sch010130513","cy2sch010130617",
"cy2sch010130516","cy2sch010130211","cy2sch010130217","cy2sch010130120","cy2sch010130221","cy2sch010130616","cy2sch010130411","cy2sch010130518", "cy2sch010130114","cy2sch010130219",
"cy2sch010130124","cy2sch010130118","cy2sch010130223"



foreach($hostname in $hostnames){
$path = "\\"+$hostname+"\drived\data\YPP\NM\hadoop-2.7.1.2.3.5.0-81\bin"
  copy -Force .\winutils.exe $path
  copy -Force .\winutils.pdb $path
}