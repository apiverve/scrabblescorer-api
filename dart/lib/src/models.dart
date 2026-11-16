/// Response models for the Scrabble Word Scorer API.

/// API Response wrapper.
class ScrabblescorerResponse {
  final String status;
  final dynamic error;
  final ScrabblescorerData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  ScrabblescorerResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory ScrabblescorerResponse.fromJson(Map<String, dynamic> json) => ScrabblescorerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ScrabblescorerData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Scrabble Word Scorer API.

class ScrabblescorerData {
  String? word;
  String? language;
  num? totalScore;
  num? letterCount;
  List<ScrabblescorerDataLetterScoresItem>? letterScores;
  ScrabblescorerDataHighestScoringLetter? highestScoringLetter;
  num? averageLetterScore;
  String? note;

  ScrabblescorerData({
    this.word,
    this.language,
    this.totalScore,
    this.letterCount,
    this.letterScores,
    this.highestScoringLetter,
    this.averageLetterScore,
    this.note,
  });

  factory ScrabblescorerData.fromJson(Map<String, dynamic> json) => ScrabblescorerData(
      word: json['word'],
      language: json['language'],
      totalScore: json['total_score'],
      letterCount: json['letter_count'],
      letterScores: (json['letter_scores'] as List?)?.map((e) => ScrabblescorerDataLetterScoresItem.fromJson(e)).toList(),
      highestScoringLetter: json['highest_scoring_letter'] != null ? ScrabblescorerDataHighestScoringLetter.fromJson(json['highest_scoring_letter']) : null,
      averageLetterScore: json['average_letter_score'],
      note: json['note'],
    );
}

class ScrabblescorerDataLetterScoresItem {
  String? letter;
  num? score;

  ScrabblescorerDataLetterScoresItem({
    this.letter,
    this.score,
  });

  factory ScrabblescorerDataLetterScoresItem.fromJson(Map<String, dynamic> json) => ScrabblescorerDataLetterScoresItem(
      letter: json['letter'],
      score: json['score'],
    );
}

class ScrabblescorerDataHighestScoringLetter {
  String? letter;
  num? score;

  ScrabblescorerDataHighestScoringLetter({
    this.letter,
    this.score,
  });

  factory ScrabblescorerDataHighestScoringLetter.fromJson(Map<String, dynamic> json) => ScrabblescorerDataHighestScoringLetter(
      letter: json['letter'],
      score: json['score'],
    );
}

class ScrabblescorerRequest {
  String word;
  String? language;

  ScrabblescorerRequest({
    required this.word,
    this.language,
  });

  Map<String, dynamic> toJson() => {
      'word': word,
      if (language != null) 'language': language,
    };
}
