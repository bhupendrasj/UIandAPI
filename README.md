# UIandAPI

Java 21-based UI and API automation framework built with Maven, Cucumber BDD, TestNG, Selenium WebDriver, and REST Assured.

## Automation coverage

- **UI (`@ui`)**: browser registration, authenticated greeting verification, and account deletion.
- **API (`@api`)**: paginated user retrieval from `GET /api/users?page=2` with status and pagination assertions.

## Run tests

```powershell
mvn clean test
mvn test "-Dcucumber.filter.tags=@ui"
mvn test "-Dcucumber.filter.tags=@api"
```

The combined Cucumber HTML and JSON reports are generated in `target/cucumber-reports/`.

## Portfolio & Execution Report

The latest combined execution report and portfolio overview are available here:

- [UIandAPI Cucumber Execution Report](portfolio/reports/UIandAPI-Execution-Report.html)
- [Portfolio overview and publishing instructions](portfolio/README.md)

The report snapshot contains **2 scenarios: 2 passed, 0 failed, 0 skipped**, with **25 passing steps**. Its portfolio copy redacts the UI scenario's test account-name, password, phone, address and location fixtures. Test results and automation source files are unchanged.

### GitHub Pages

To publish this report through GitHub Pages, first commit the portfolio files. In the repository, open **Settings → Pages**, select **Deploy from a branch**, choose the `main` branch and `/(root)` folder, then save. The report will be available at:

```text
https://<OWNER>.github.io/<REPOSITORY>/portfolio/reports/UIandAPI-Execution-Report.html
```

Branch-based Pages publishing supports the repository root or `/docs`, not an arbitrary `/portfolio` source folder ([GitHub Pages publishing sources](https://docs.github.com/en/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site)). A custom GitHub Actions workflow can publish a selected folder; if publishing the contents of `portfolio/` as the site root, provide an `index.html` at the artifact root ([custom Pages workflows](https://docs.github.com/en/pages/getting-started-with-github-pages/using-custom-workflows-with-github-pages)). No Pages workflow is included in this project.
