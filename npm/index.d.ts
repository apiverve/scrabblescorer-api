declare module '@apiverve/scrabblescorer' {
  export interface scrabblescorerOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface scrabblescorerResponse {
    status: string;
    error: string | null;
    data: ScrabbleWordScorerData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface ScrabbleWordScorerData {
      word:                 null | string;
      language:             null | string;
      totalScore:           number | null;
      letterCount:          number | null;
      letterScores:         HighestScoringLetter[];
      highestScoringLetter: HighestScoringLetter;
      averageLetterScore:   number | null;
      note:                 null | string;
  }
  
  interface HighestScoringLetter {
      letter: null | string;
      score:  number | null;
  }

  export default class scrabblescorerWrapper {
    constructor(options: scrabblescorerOptions);

    execute(callback: (error: any, data: scrabblescorerResponse | null) => void): Promise<scrabblescorerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: scrabblescorerResponse | null) => void): Promise<scrabblescorerResponse>;
    execute(query?: Record<string, any>): Promise<scrabblescorerResponse>;
  }
}
