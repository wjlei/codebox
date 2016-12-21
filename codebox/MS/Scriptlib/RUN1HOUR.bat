for /l %%x in (1, 1, 120) do (
    echo %%x
    ping 127.0.0.1 -n 30 > nul
)