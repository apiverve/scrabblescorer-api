using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.ScrabbleWordScorer
{
    /// <summary>
    /// Query options for the Scrabble Word Scorer API
    /// </summary>
    public class ScrabbleWordScorerQueryOptions
    {
        /// <summary>
        /// The word to score
        /// Example: QUIZ
        /// </summary>
        [JsonProperty("word")]
        public string Word { get; set; }

        /// <summary>
        /// Scrabble language variant: english, french, spanish, german, or italian (default: english)
        /// Example: english
        /// </summary>
        [JsonProperty("language")]
        public string Language { get; set; }
    }
}
