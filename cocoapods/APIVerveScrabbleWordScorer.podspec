Pod::Spec.new do |s|
  s.name             = 'APIVerveScrabbleWordScorer'
  s.version          = '1.2.3'
  s.summary          = 'Scrabble Word Scorer calculates the official Scrabble score for any word across five languages.'
  s.description      = <<-'DESC'
Scrabble Word Scorer calculates the official Scrabble score for any word across five languages. It provides the total base points, letter count, and point values for each individual letter.

This iOS/macOS SDK provides a convenient way to access the Scrabble Word Scorer from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/scrabblescorer?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/scrabblescorer-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveScrabbleWordScorer/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
