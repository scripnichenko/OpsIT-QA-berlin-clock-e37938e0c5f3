Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase the number of ways that I can read the time

//TODO - write at least a few acceptance tests
given 	‘Given’ 	Given-When-Then
when 	‘When’ 	Given-When-Then
then 	‘Then’ 	Given-When-Then
and 	‘And’ 	Given-When-Then
but 	‘But’ 	Given-When-Then

Abbreviation for Lamps possible values

O = Off
Y = Yellow
R = Red

At 00:00:00 clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO


Acceptance Test Cases:
Scenario: 00:00:00 Time Berlin clock representation
When Current time is 00:00:00
Then On the top of the clock there is a yellow lamp that is On
Then The top row of red lamps has values OOOO
Then lower row of red lamps has values OOOO
Then The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values OOOOOOOOOOO
Then In the last row with 4 lamps has values OOOO



At 13:17:01 clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO


Scenario: 13:17:01 Time Berlin clock representation
Given Current time is 13:17:01
When On the top of the clock there is a yellow lamp that is Off
Then The top row of red lamps has values RROO
And lower row of red lamps has values RRRO
And The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values YYROOOOOOOO
And In the last row with 4 lamps has values YYOO

At 23:59:59 clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: 23:59:59 Time Berlin clock representation
Given Current time is 23:59:59
When On the top of the clock there is a yellow lamp that is Off
Then The top row of red lamps has values RRRR
And lower row of red lamps has values RRRO
And The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values YYRYYRYYRYY
And In the last row with 4 lamps has values YYYY

At 24:00:00 clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: 24:00:00 Time Berlin clock representation
Given Current time is 24:00:00
When On the top of the clock there is a yellow lamp that is On
Then The top row of red lamps has values RRRR
And lower row of red lamps has values RRRR
And The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps and values OOOOOOOOOOO
And In the last row with 4 lamps has values OOOO
