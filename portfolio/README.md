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

GitHub Pages branch publishing can use the repository root or a `/docs` folder as its source; it cannot select `portfolio/` directly ([publishing source documentation](https://docs.github.com/en/pages/getting-started-with-github-pages/configuring-a-publishing-source-for-your-github-pages-site)). To publish from the existing project without adding a workflow:

1. Commit `portfolio/README.md` and `portfolio/reports/UIandAPI-Execution-Report.html` to the `main` branch.
2. In the GitHub repository, open **Settings → Pages**.
3. Select **Deploy from a branch**, choose `main` and `/(root)`, then save.
4. Open the report at `https://<OWNER>.github.io/<REPOSITORY>/portfolio/reports/UIandAPI-Execution-Report.html`.

To publish only the portfolio directory as the site root, use a [GitHub Actions Pages workflow](https://docs.github.com/en/pages/getting-started-with-github-pages/using-custom-workflows-with-github-pages) and upload `portfolio/` as the Pages artifact. The artifact must have an `index.html` at its top level; this project does not currently include that landing page or a deploy workflow. GitHub Pages content is public, so review the portfolio files before publishing.
