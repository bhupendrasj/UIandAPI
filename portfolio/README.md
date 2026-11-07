# UIandAPI Automation Portfolio

## Project overview

UIandAPI is a Java test automation framework that exercises web user workflows and REST API behavior with Cucumber scenarios. It keeps browser and API coverage in the existing Maven and TestNG runner structure.

## Technology stack

- Java 21
- Selenium WebDriver
- Cucumber BDD
- TestNG
- REST Assured
- Maven

## Automation coverage

The combined execution report contains these scenarios from the project feature file:

- **User successfully registers and deletes their account** (`@smoke`, `@ui`): registers a user, verifies the authenticated greeting, and deletes the account.
- **User Fetch a list of users with pagination** (`@smoke`, `@api`): sends `GET /api/users?page=2`, validates HTTP 200 and pagination response data.

## Latest combined execution results

These figures come from the latest generated `target/cucumber-reports/cucumber.json`:

- Scenarios: **2 total** — **2 passed**, **0 failed**, **0 skipped**
- Pass rate: **100%**
- Steps: **25 total**, all passed
- Recorded step duration total: **16.63 seconds** (sum of Cucumber step durations; excludes setup and other runner overhead)

The portfolio HTML copy redacts the test-only account-name, password, phone, address, and location values embedded from the feature source. The generated execution report and test files are unchanged.

## Run the tests

From the repository root in PowerShell:

```powershell
mvn clean test
```

Run either tagged scenario independently:

```powershell
mvn test "-Dcucumber.filter.tags=@ui"
mvn test "-Dcucumber.filter.tags=@api"
```

`mvn clean test` removes prior generated output before running both scenarios, then creates fresh reports under `target/cucumber-reports/`.

## Open the HTML report

Open [UIandAPI-Execution-Report.html](reports/UIandAPI-Execution-Report.html) in a browser, or use PowerShell from the repository root:

```powershell
Invoke-Item .\portfolio\reports\UIandAPI-Execution-Report.html
```

The standalone Cucumber HTML report includes scenario names and tags, individual step outcomes, timing, and failure details when failures occur. Failed UI scenarios attach a browser screenshot to the Cucumber report.

## GitHub Pages publishing

The repository workflow `.github/workflows/deploy-portfolio-pages.yml` publishes this directory whenever `portfolio/` or the workflow changes on `master`. It can also be run manually from the Actions tab on `master`.

Before the first deployment, open the repository's **Settings > Pages > Build and deployment** and select **GitHub Actions** as the source. After the workflow succeeds, visit:

- Portfolio: <https://bhupendrasj.github.io/UIandAPI/>
- Execution report: <https://bhupendrasj.github.io/UIandAPI/reports/UIandAPI-Execution-Report.html>

The GitHub Pages workflow must be committed and pushed to `master` before it can deploy. Publishing requires the Pages Actions permissions shown in the workflow.
