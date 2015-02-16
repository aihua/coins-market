Coins market

How to start:

1. Place your own settings into "config.properties", example here "src\main\resources\config.properties".
2. Change in application-context.xml path to "config.properties" if needed, e.g. "config.properties" can be placed at tomcat conf directory.
3. Start mysql database.
4. Run "mysql-init-schema.sql" on your database for creating structure.
5. Optional: run mysql-init-data.sql for populate database with initial data.
6. Create xml price matrix file in place that you set in p.1: "price.file.path".
7. Build project.
8. Deploy artifact on tomcat.
9. Open in browser "http://localhost:8080/".
And now you should see table with coins.

How to refresh price matrix file content:

1. Change price matrix file and save it in right place.
2. Open jConsole.
3. Connect to tomcat.
4. Find been/priceTypeService and method refreshPriceTypeFromFile();
5. Invoke it.
Now you new file loaded to system.

Need to be done:
1. Functionality of adding coins from UI.
2. UI visualisation of countries and subscribers in system.
3. Full functional tests.