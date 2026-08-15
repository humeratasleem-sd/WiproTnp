# Servlet Running Guide

## Complete Documentation for Running Your Servlet Programs

---

## **ERRORS EXPLAINED**

### **1. File Not Found Error**

**Error Message:**
```
error: file not found: src\Servlets\GetAndPostRequests\Probllem1\RequestHeadersServlet.java
Usage: javac <options> <source files>
use --help for a list of possible options
```

**Why This Happens:**
- The javac command is being executed from the wrong directory
- When you run commands from Tomcat's bin directory, the relative paths like `src/...` don't exist
- The system can't find the file because it's looking in the wrong location

**Solution:**
- Always navigate to your project root first: `c:\Users\syedt\eclipse-workspace\WiproTNP`
- Then run javac from that location
- Relative paths will work correctly from the project root

---

### **2. Package Name Mismatch Error**

**Error (in web.xml):**
```xml
<!-- WRONG - This causes ClassNotFoundException at runtime -->
<servlet-class>Servlets.GetAndPostRequests.Problem2.RequestParametersServlet</servlet-class>

<!-- CORRECT - Must match actual package -->
<servlet-class>Servlets.GetAndPostRequests.problem2.RequestParametersServlet</servlet-class>
```

**Why This Happens:**
- Java package names are **CASE-SENSITIVE**
- Your folder structure uses lowercase: `problem2`
- But the Java source code package declaration is also lowercase: `package Servlets.GetAndPostRequests.problem2;`
- If web.xml doesn't match exactly, Tomcat can't find the class

**Solution:**
- Always check the actual folder names in your project
- Match the exact case in web.xml servlet-class elements
- Verify the package declaration in your Java file matches the folder structure

---

### **3. ClassNotFoundException at Runtime**

**Error in Tomcat logs:**
```
SEVERE: Exception starting application at context path [/WiproTNP]
java.lang.ClassNotFoundException: Servlets.GetAndPostRequests.Problem2.RequestParametersServlet
```

**Why This Happens:**
- Compiled classes weren't deployed to Tomcat
- web.xml wasn't updated in Tomcat's deployment
- Tomcat wasn't restarted after changes

**Solution:**
- Copy compiled files: `xcopy "WebContent\WEB-INF\classes\*" to Tomcat\webapps\...`
- Copy updated web.xml: `copy "WebContent\WEB-INF\web.xml" to Tomcat\webapps\...`
- Restart Tomcat: `shutdown.bat` then `startup.bat`

---

## **STEP-BY-STEP COMMANDS TO RUN YOUR CODE**

### **Prerequisites:**
- Java JDK installed (JavaSE-21 or higher)
- Tomcat 10.1.23 installed
- Project location: `c:\Users\syedt\eclipse-workspace\WiproTNP`

---

### **STEP 1: Open Command Prompt and Navigate to Project**

```bash
cd c:\Users\syedt\eclipse-workspace\WiproTNP
```

**What this does:** Changes your current directory to the project root so relative paths work correctly.

---

### **STEP 2: Compile RequestHeadersServlet**

```bash
javac -cp "C:/Users/syedt/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.23/apache-tomcat-10.1.23/lib/servlet-api.jar" -d "WebContent/WEB-INF/classes" "src/Servlets/GetAndPostRequests/Probllem1/RequestHeadersServlet.java"
```

**Breakdown:**
- `javac` - Java compiler
- `-cp "..."` - Classpath (location of servlet-api.jar for Jakarta Servlet API)
- `-d "WebContent/WEB-INF/classes"` - Output directory for compiled .class files
- `"src/Servlets/..."` - Source file to compile

**Expected Output:**
- No output = Success ✓
- Error message = Problem in code or wrong path

---

### **STEP 3: Compile RequestParametersServlet**

```bash
javac -cp "C:/Users/syedt/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.23/apache-tomcat-10.1.23/lib/servlet-api.jar" -d "WebContent/WEB-INF/classes" "src/Servlets/GetAndPostRequests/problem2/RequestParametersServlet.java"
```

**Note:** `problem2` is lowercase in folder name and in package declaration.

---

### **STEP 4: Deploy Compiled Classes to Tomcat**

```bash
xcopy "WebContent\WEB-INF\classes\*" "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\webapps\WiproTNP\WEB-INF\classes\" /S /Y /Q
```

**Breakdown:**
- `xcopy` - Copy command with options
- `"WebContent\WEB-INF\classes\*"` - Source (all compiled files from your project)
- `/S` - Copy subdirectories
- `/Y` - Don't ask for confirmation
- `/Q` - Quiet mode (minimal output)

**Expected Output:**
```
279 File(s) copied
```

---

### **STEP 5: Deploy Updated web.xml to Tomcat**

```bash
copy "WebContent\WEB-INF\web.xml" "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\webapps\WiproTNP\WEB-INF\" /Y
```

**What this does:** Updates Tomcat's copy of web.xml with your servlet mappings.

**Expected Output:**
```
1 file(s) copied.
```

---

### **STEP 6: Navigate to Tomcat bin Directory**

```bash
cd "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\bin"
```

---

### **STEP 7: Shutdown Tomcat (if running)**

```bash
shutdown.bat
```

**Wait 2-3 seconds for graceful shutdown:**
```bash
timeout /t 2 /nobreak
```

**Expected Output:**
```
Using CATALINA_BASE:   "C:\Users\syedt\.rsp\...\apache-tomcat-10.1.23"
Using CATALINA_HOME:   "C:\Users\syedt\.rsp\...\apache-tomcat-10.1.23"
```

---

### **STEP 8: Start Tomcat**

```bash
startup.bat
```

**Expected Output:**
```
Using CATALINA_BASE:   "C:\Users\syedt\.rsp\...\apache-tomcat-10.1.23"
Using CATALINA_HOME:   "C:\Users\syedt\.rsp\...\apache-tomcat-10.1.23"
Using CATALINA_TMPDIR: "C:\Users\syedt\.rsp\...\apache-tomcat-10.1.23\temp"
Using JRE_HOME:        "C:\Program Files\Java\jdk-25.0.2"
```

Then a new command prompt appears. Tomcat is running in background.

---

## **ACCESS YOUR SERVLETS**

Once Tomcat is running, open your browser and visit:

| Servlet | URL |
|---------|-----|
| FirstServlet | http://localhost:8080/WiproTNP/first |
| RequestHeadersServlet | http://localhost:8080/WiproTNP/headers |
| RequestParametersServlet | http://localhost:8080/WiproTNP/parameters |

---

## **QUICK BATCH FILE (ONE-CLICK EXECUTION)**

Create a file named `run.bat` in your project root with this content:

```batch
@echo off
echo ========================================
echo Compiling Servlets...
echo ========================================
cd /d c:\Users\syedt\eclipse-workspace\WiproTNP

echo.
echo Compiling RequestHeadersServlet...
javac -cp "C:/Users/syedt/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.23/apache-tomcat-10.1.23/lib/servlet-api.jar" -d "WebContent/WEB-INF/classes" "src/Servlets/GetAndPostRequests/Probllem1/RequestHeadersServlet.java"
if errorlevel 1 (
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)
echo ✓ RequestHeadersServlet compiled successfully

echo.
echo Compiling RequestParametersServlet...
javac -cp "C:/Users/syedt/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.23/apache-tomcat-10.1.23/lib/servlet-api.jar" -d "WebContent/WEB-INF/classes" "src/Servlets/GetAndPostRequests/problem2/RequestParametersServlet.java"
if errorlevel 1 (
    echo ERROR: Compilation failed!
    pause
    exit /b 1
)
echo ✓ RequestParametersServlet compiled successfully

echo.
echo ========================================
echo Deploying to Tomcat...
echo ========================================
xcopy "WebContent\WEB-INF\classes\*" "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\webapps\WiproTNP\WEB-INF\classes\" /S /Y /Q
copy "WebContent\WEB-INF\web.xml" "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\webapps\WiproTNP\WEB-INF\" /Y

echo ✓ Deployment completed

echo.
echo ========================================
echo Restarting Tomcat...
echo ========================================
cd "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\bin"
shutdown.bat
timeout /t 2 /nobreak
startup.bat

echo.
echo ✓ Tomcat started!
echo.
echo ========================================
echo ACCESS YOUR SERVLETS:
echo ========================================
echo FirstServlet:             http://localhost:8080/WiproTNP/first
echo RequestHeadersServlet:    http://localhost:8080/WiproTNP/headers
echo RequestParametersServlet: http://localhost:8080/WiproTNP/parameters
echo ========================================
pause
```

**Usage:** Just double-click `run.bat` and it will:
1. Compile both servlets
2. Deploy to Tomcat
3. Restart Tomcat
4. Display URLs to access

---

## **TROUBLESHOOTING**

### **Problem: "File not found" when compiling**

**Solution:**
```bash
# Make sure you're in the project root
cd c:\Users\syedt\eclipse-workspace\WiproTNP

# Verify the file exists
dir "src\Servlets\GetAndPostRequests\Probllem1\RequestHeadersServlet.java"

# Then run javac
javac -cp "..." -d "WebContent/WEB-INF/classes" "src/..."
```

---

### **Problem: "Port 8080 already in use" or "Tomcat won't start"**

**Solution:**
```bash
# Go to Tomcat bin directory
cd "C:\Users\syedt\.rsp\redhat-community-server-connector\runtimes\installations\tomcat-10.1.23\apache-tomcat-10.1.23\bin"

# Shutdown any running instance
shutdown.bat

# Wait
timeout /t 3 /nobreak

# Start again
startup.bat
```

---

### **Problem: 404 error when accessing servlet URL**

**Checklist:**
- [ ] Tomcat is running (check console window is open)
- [ ] web.xml is updated with servlet mapping
- [ ] Compiled .class files are in `WebContent/WEB-INF/classes`
- [ ] Package name in web.xml matches package in Java file
- [ ] URL pattern is correct (check web.xml for `/headers`, `/parameters`, etc.)

---

### **Problem: ClassNotFoundException in Tomcat logs**

**Solution:**
1. Check web.xml servlet-class matches actual package name (case-sensitive)
2. Recompile: `javac ... RequestHeadersServlet.java`
3. Redeploy: `xcopy WebContent\WEB-INF\classes\...`
4. Restart Tomcat: `shutdown.bat` then `startup.bat`

---

## **DIRECTORY STRUCTURE REFERENCE**

```
c:\Users\syedt\eclipse-workspace\WiproTNP\
├── src\
│   └── Servlets\
│       ├── IntroductionToServlets\
│       │   └── Problem1\
│       │       └── FirstServlet.java
│       └── GetAndPostRequests\
│           ├── Probllem1\                    ← NOTE: typo "Probllem"
│           │   └── RequestHeadersServlet.java
│           └── problem2\                     ← lowercase "problem"
│               └── RequestParametersServlet.java
├── WebContent\
│   └── WEB-INF\
│       ├── classes\                         ← Compiled .class files go here
│       │   └── Servlets\...
│       └── web.xml                          ← Servlet mappings defined here
└── run.bat                                  ← Your quick execution script
```

---

## **KEY POINTS TO REMEMBER**

1. **Always run from project root:** `c:\Users\syedt\eclipse-workspace\WiproTNP`
2. **Package names are case-sensitive:** `problem2` ≠ `Problem2`
3. **Update both files in Tomcat:** Compiled classes AND web.xml
4. **Restart Tomcat after changes:** Old classes may be cached
5. **Check folder structure:** File locations must match package declarations
6. **Use the batch file:** Saves time and reduces errors

---

## **SUMMARY CHECKLIST**

- [ ] Navigate to: `c:\Users\syedt\eclipse-workspace\WiproTNP`
- [ ] Compile all servlets with javac
- [ ] Copy compiled files to Tomcat deployment
- [ ] Copy web.xml to Tomcat deployment
- [ ] Shutdown and restart Tomcat
- [ ] Access servlets via browser URLs
- [ ] Check Tomcat logs if issues occur

---

**Created:** August 15, 2026  
**For Project:** WiproTNP  
**Server:** Apache Tomcat 10.1.23
