Feature: feature to log in

Scenario:log in to user
Given launch browser
When set url
Then verify title
And login as student
And verify login is succesfull
And close session

