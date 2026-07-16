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
        /// </summary>
        [JsonProperty("word")]
        public string Word { get; set; }

        /// <summary>
        /// Scrabble language variant
        /// </summary>
        [JsonProperty("language")]
        public string Language { get; set; }
    }
}
