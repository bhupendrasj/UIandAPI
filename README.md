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

The `master` branch workflow at `.github/workflows/deploy-portfolio-pages.yml` publishes the `portfolio/` directory, including its landing page and Cucumber report. In the repository settings, select **Settings > Pages > Build and deployment > Source: GitHub Actions**. After the workflow runs successfully, the portfolio will be at:

```text
https://bhupendrasj.github.io/UIandAPI/
```

The report is available at `https://bhupendrasj.github.io/UIandAPI/reports/UIandAPI-Execution-Report.html`. Deployment starts after the workflow is committed and pushed to `master`, or when manually dispatched on `master`.
