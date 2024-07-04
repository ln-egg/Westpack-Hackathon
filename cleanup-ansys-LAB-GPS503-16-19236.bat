@echo off
set LOCALHOST=%COMPUTERNAME%
if /i "%LOCALHOST%"=="LAB-GPS503-16" (taskkill /f /pid 20876)
if /i "%LOCALHOST%"=="LAB-GPS503-16" (taskkill /f /pid 21540)
if /i "%LOCALHOST%"=="LAB-GPS503-16" (taskkill /f /pid 22344)
if /i "%LOCALHOST%"=="LAB-GPS503-16" (taskkill /f /pid 19236)

del /F cleanup-ansys-LAB-GPS503-16-19236.bat
