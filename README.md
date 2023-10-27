# seriouswisher
Another thing I made for AP CS

Not very good code but it works*
### building
##### prereqs
- Maven 3.2.5+ required, 3.8.x+ recommended
- Java runtime 17+ required
##### building on windows
1. Navigate to the root directory of the downloaded repo (The folder with the pom.xml file)
2. Verify with `mvn --version` that you meet the prerequisites
3. Run `mvn compile` then `mvn package` to build the project
4. The executable jar can then be found in the `target` directory
5. Run as `java -jar target\JAR_NAME_HERE.jar`
