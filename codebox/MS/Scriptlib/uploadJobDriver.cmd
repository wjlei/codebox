rem --------------------------------------
rem SUBROUTINE "update JobDriver on HDFS"
rem

pushd %~dp0
call JobDriver\iniJobDriver.cmd


rem update JobDriver binary on the hdfs of different clusters
for /d %%d in (clusters\*) do call :updateJobDriver %%d %hemerapath%

popd

exit /b


:updateJobDriver
set clusterConfDir=%1
set JobDriverHome=%2

call %clusterConfDir%\env_hadoop.cmd
set hdfsCmd=hdfs --config %clusterConfDir%\hadoop dfs

call %hdfsCmd% -test -e %JobDriverHome%/JobDriver%jbversion%/done

if %ERRORLEVEL% == 0 (
    echo %clusterConfDir% upload already finished 
) else (
    echo "start upload"
    call %hdfsCmd% -test -d %JobDriverHome%/JobDriver%jbversion%
	
    if %ERRORLEVEL% == 0 (
       call %hdfsCmd% -rmr %JobDriverHome%/JobDriver%jbversion%
    )
    rem copy the config file over
    robocopy /E %clusterConfDir%\JobDriver JobDriver

    echo updating JobDriver on cluster %clusterConfDir% in %JobDriverHome% 
    call %hdfsCmd% -mkdir %JobDriverHome%

    echo %JobDriverHome%/JobDriver%jbversion%
    call %hdfsCmd% -put JobDriver %JobDriverHome%/JobDriver%jbversion%
    call %hdfsCmd% -touchz %JobDriverHome%/JobDriver%jbversion%/done
)