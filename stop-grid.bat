@echo off

echo ===================================
echo Stopping Selenium Docker Grid
echo ===================================

cd /d C:\Users\bhupe\IdeaProjects\UIandAPI

docker compose down

echo.
echo ===================================
echo Grid Stopped Successfully
echo ===================================

pause