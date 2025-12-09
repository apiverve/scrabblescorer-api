declare module '@apiverve/scrabblescorer' {
  export interface scrabblescorerOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface scrabblescorerResponse {
    status: string;
    error: string | null;
    data: ScrabbleWordScorerData;
    code?: number;
  }


  interface ScrabbleWordScorerData {
      word:                 string;
      language:             string;
      totalScore:           number;
      letterCount:          number;
      letterScores:         HighestScoringLetter[];
      highestScoringLetter: HighestScoringLetter;
      averageLetterScore:   number;
      note:                 string;
  }
  
  interface HighestScoringLetter {
      letter: string;
      score:  number;
  }

  export default class scrabblescorerWrapper {
    constructor(options: scrabblescorerOptions);

    execute(callback: (error: any, data: scrabblescorerResponse | null) => void): Promise<scrabblescorerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: scrabblescorerResponse | null) => void): Promise<scrabblescorerResponse>;
    execute(query?: Record<string, any>): Promise<scrabblescorerResponse>;
  }
}
