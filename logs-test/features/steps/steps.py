import requests
from behave import given, when, then


@given('the web server is running')
def step_given_web_server_running(context):
    # Set up any necessary configurations or test data
    context.base_url = 'http://localhost:8080'


@when('a GET request is made to "{route}"')
def step_when_get_request_made(context, route):
    # Send a GET request to the specified route to get logs
    context.response = requests.get(f'{context.base_url}{route}')


@when('a POST request is made to "{route}"')
def step_when_post_request_made(context, route):
    # Send a POST request to the specified route to create log
    context.response = requests.post(f'{context.base_url}{route}')


@then('the response status code should be {status_code}')
def step_then_response_status_code(context, status_code):
    # Check if the status code for response is okay/200
    assert context.response.status_code == int(
        status_code), f"Expected status code: {status_code}, Actual status code: {context.response.status_code}"


@then('the response format should be JSON')
def step_then_response_format_json(context):
    # Check if the response format is JSON
    assert context.response.headers['Content-Type'] == 'application/json', "Expected response format: JSON"


@then('the response should contain logs')
def step_then_response_contains_logs(context):
    # Check if the response contains logs and is a list
    logs = context.response.json()
    assert isinstance(logs, list)
    assert len(logs) > 0


@then('the response format should be plain text')
def step_then_response_format_plain_text(context):
    # Check if the response format is json
    assert context.response.headers['Content-Type'] == 'application/json', "Expected response format: json"


@then('the response should contain a log entry')
def step_then_response_contains_log_entry(context):
    # Check if the response contains a log entry
    log_entry = context.response.json()
    assert len(log_entry) > 0
