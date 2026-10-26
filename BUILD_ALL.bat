@echo off
setlocal
set ROOT=%~dp0
for /L %%N in (1,1,13) do (
  set NUM=0%%N
  call :build %%N
  if errorlevel 1 exit /b 1
)
cd /d "%ROOT%Practical14"
if not exist out mkdir out
javac --release 17 -d out src\main\java\model\annotation\*.java src\main\java\model\*.java src\main\java\exception\*.java src\main\java\util\*.java src\main\java\repository\*.java src\main\java\service\*.java src\main\java\MiniBank.java
if errorlevel 1 exit /b 1
jar --create --file MiniBank.jar --main-class MiniBank -C out .
if errorlevel 1 exit /b 1
echo All practicals compiled successfully and Practical14 MiniBank.jar was created.
exit /b 0
:build
set N=0%1
set N=%N:~-2%
cd /d "%ROOT%Practical%N%"
javac --release 17 MiniBank.java
if errorlevel 1 exit /b 1
exit /b 0
