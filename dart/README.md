# Scrabble Word Scorer API - Dart/Flutter Client

Scrabble Word Scorer calculates the official Scrabble score for any word across five languages. It provides the total base points, letter count, and point values for each individual letter.

[![pub package](https://img.shields.io/pub/v/apiverve_scrabblescorer.svg)](https://pub.dev/packages/apiverve_scrabblescorer)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Scrabble Word Scorer API](https://apiverve.com/marketplace/scrabblescorer?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_scrabblescorer: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_scrabblescorer/apiverve_scrabblescorer.dart';

void main() async {
  final client = ScrabblescorerClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'word': 'QUIZ',
      'language': 'english'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Scrabble Word Scorer API](https://apiverve.com/marketplace/scrabblescorer?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/scrabblescorer](https://docs.apiverve.com/ref/scrabblescorer?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
