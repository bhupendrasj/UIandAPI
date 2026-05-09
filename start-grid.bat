@echo off

echo ===================================
echo Starting Selenium Docker Grid
echo ===================================

cd /d C:\Users\bhupe\IdeaProjects\UIandAPI

docker compose up -d

echo.
echo ===================================
echo Grid Started Successfully
echo ===================================
echo Grid URL  : http://localhost:4444
echo VNC URL   : http://localhost:7900
echo Password  : secret
echo ===================================

pause