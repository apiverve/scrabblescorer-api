Scrabble Word Scorer API
============

Scrabble Word Scorer is a tool for calculating Scrabble points for words. It supports multiple languages including English, French, Spanish, German, and Italian with language-specific letter values.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Scrabble Word Scorer API](https://apiverve.com/marketplace/api/scrabblescorer)

---

## Installation
	pip install apiverve-scrabblewordscorer

---

## Configuration

Before using the scrabblescorer API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Scrabble Word Scorer API documentation is found here: [https://docs.apiverve.com/api/scrabblescorer](https://docs.apiverve.com/api/scrabblescorer).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_scrabblewordscorer.apiClient import ScrabblescorerAPIClient

# Initialize the client with your APIVerve API key
api = ScrabblescorerAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "word": "QUIZ", "language": "english" }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "word": "QUIZ",
    "language": "english",
    "total_score": 22,
    "letter_count": 4,
    "letter_scores": [
      {
        "letter": "Q",
        "score": 10
      },
      {
        "letter": "U",
        "score": 1
      },
      {
        "letter": "I",
        "score": 1
      },
      {
        "letter": "Z",
        "score": 10
      }
    ],
    "highest_scoring_letter": {
      "letter": "Q",
      "score": 10
    },
    "average_letter_score": 5.5,
    "note": "Scores do not include board multipliers (double/triple letter/word)"
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.