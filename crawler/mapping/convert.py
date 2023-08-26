# Load a html file with a table and convert it to a json file

import json
import pandas as pd

# Load a html file
def load_html_file(file_path):
    with open(file_path, 'r') as f:
        html = f.read()
    return html

# Convert a html file to a json file
def convert_html_to_dict(html_data):
    # Load the html file into a pandas dataframe
    df = pd.read_html(html_data, header=0)[0]

    # Print the dataframe
    print(df)

    # Convert the dataframe to a python array with dictionaries
    # The keys of the dictionaries are the column names
    # The values of the dictionaries are the values of the dataframe
    data = df.to_dict(orient='records')

    return data

# Save a json file
def save_json_file(json_file, file_path):
    with open(file_path, 'w') as f:
        f.write(json_file)
    return

htmldata = load_html_file("./data.html")
data = convert_html_to_dict(htmldata)

# Rename the key 'Gemeindename' to 'municipality'
for d in data:
    d['municipality'] = d.pop('Gemeindename')
    d['hist_nr'] = d.pop('Hist.-Nummer')
    d['canton'] = d.pop('Kanton')
    d['district'] = d.pop('Bezirksname')
    d['district_nr'] = d.pop('Bezirks-nummer')
    d['bfs_nr'] = d.pop('BFS-Gde Nummer')
    d['date_of_entry'] = d.pop('Datum der Aufnahme')
    d.pop('Datum der Aufhebung')

# Write the dict to a json file
jsondata = json.dumps(data, ensure_ascii=False, indent=4)
save_json_file(jsondata, "./data.json")
