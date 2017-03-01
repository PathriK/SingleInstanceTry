start "cmd1" cmd.exe /K "java -jar target\single-instance-try.jar"
TIMEOUT 2
start "cmd2" cmd.exe /K "java -jar target\single-instance-try.jar"