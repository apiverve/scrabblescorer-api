# Scrabble Word Scorer API - PHP Package

Scrabble Word Scorer calculates the official Scrabble score for any word across five languages. It provides the total base points, letter count, and point values for each individual letter.

## Installation

Install via Composer:

```bash
composer require apiverve/scrabblescorer
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Scrabblescorer\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'word' => 'QUIZ',
    'language' => 'english'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Scrabblescorer\Client;
use APIVerve\Scrabblescorer\Exceptions\APIException;
use APIVerve\Scrabblescorer\Exceptions\ValidationException;

try {
    $response = $client->execute(['word' => 'QUIZ', 'language' => 'english']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/scrabblescorer?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/scrabblescorer?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/scrabblescorer?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
