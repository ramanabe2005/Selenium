Feature: Test Facebook smoke scenario

Scenario: Test login with valid credentials
Given Open Chrome or Firefox and start the application
When I enter valid "ramana643@gmail.com" and "@may2017"
Then User should be able to login successfully


