# Scrabble Word Scorer API - Ruby Gem

Scrabble Word Scorer calculates the official Scrabble score for any word across five languages. It provides the total base points, letter count, and point values for each individual letter.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_scrabblescorer'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_scrabblescorer
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_scrabblescorer'

# Initialize the client
client = APIVerve::Scrabblescorer::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  word: "QUIZ",
  language: "english"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ word: "QUIZ", language: "english" })
  puts response["data"]
rescue APIVerve::Scrabblescorer::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Scrabblescorer::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Scrabblescorer::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/scrabblescorer?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/scrabblescorer?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/scrabblescorer?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
