Quick setup — if you’ve done this kind of thing before
or	
https://github.com/ToddEricWhitehead/bigDog.git
Get started by creating a new file or uploading an existing file. We recommend every repository include a README, LICENSE, and .gitignore.

…or create a new repository on the command line
https://github.com/ToddEricWhitehead <- need to create repository 'bigDog' here first - no README no .gitignore
echo "# bigDog" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/ToddEricWhitehead/bigDog.git
git push -u origin main

…or push an existing repository from the command line
git remote add origin https://github.com/ToddEricWhitehead/bigDog.git
git branch -M main
git push -u origin main


.gitignore
-----
.classpath
.classpath
.project
.settings/
target/

branch - embedded-mykong [embeddedDB-mkyong 718da8d] 
---
Credit:
 - Spring embedded database examples - By mkyong 
 - https://mkyong.com/spring/spring-embedded-database-examples/

Goal: 
 - 1) Get tests with live mySql database to work - using bean.xml in Test 
 - 2) Get Embedded Database to work using hsqldb - both call the same Test 
 - Next separate into two tests & Make a test for each of the Embedded DB types db-derby, h2 
   -- also Auto increment in hsqldb did not work - find out why.

