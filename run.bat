@echo off
echo ========================================
echo SERVLET COMPILATION & DEPLOYMENT SCRIPT
echo ========================================
cd /d c:\Users\syedt\eclipse-workspace\WiproTNP

echo.
echo Step 1: Compiling RequestHeadersServlet...
javac -cp "C:/Users/syedt/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.23/apache-tomcat-10.1.23/lib/servlet-api.jar" -d "WebContent/WEB-INF/classes" "src/Servlets/GetAndPostRequests/Probllem1/RequestHeadersServlet.java"
if errorlevel 1 (
    echo [ERROR] RequestHeadersServlet compilation failed!
    pause
    exit /b 1
)
echo [OK] RequestHeadersServlet compiled

echo.
echo Step 2: Compiling RequestParametersServlet...
javac -cp "C:/Users/syedt/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.23/apache-tomcat-10.1.23/lib/servlet-api.jar" -d "WebContent/WEB-INF/classes" "src/Servlets/GetAndPostRequests/problem2/RequestParametersServlet.java"
if errorlevel 1 (
    echo [ERROR] RequestParametersServlet compilation failed!
    pause
    exit /b 1
)
echo [OK] RequestParametersServlet compiled

echo.
echo Step 3: Deploying compiled classes to Tomcat...
xcopy "WebContent\WEB-INF\classes\*" "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\webapps\WiproTNP\WEB-INF\classes\" /S /Y /Q
echo [OK] Classes deployed

echo.
echo Step 4: Deploying web.xml to Tomcat...
copy "WebContent\WEB-INF\web.xml" "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\webapps\WiproTNP\WEB-INF\" /Y
echo [OK] web.xml deployed

echo.
echo Step 5: Shutting down Tomcat...
cd "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\bin"
shutdown.bat > nul 2>&1
echo [OK] Shutdown initiated

echo.
echo Step 6: Waiting for Tomcat to stop...
timeout /t 3 /nobreak

echo.
echo Step 7: Starting Tomcat...
startup.bat

echo.
echo ========================================
echo SUCCESS! Tomcat is now running
echo ========================================
echo.
echo Access your servlets at:
echo   FirstServlet:             http://localhost:8080/WiproTNP/first
echo   RequestHeadersServlet:    http://localhost:8080/WiproTNP/headers  
echo   RequestParametersServlet: http://localhost:8080/WiproTNP/parameters
echo.
echo ========================================
pause
