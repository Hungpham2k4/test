$ErrorActionPreference = 'stop'
$actor = $env:GITHUB_ACTOR -replace '([_\*\[\]\(\)\~\>\#\+\-\=\|\{\}\.\!])', '\\$1'
$repo = $env:GITHUB_REPOSITORY -replace '([_\*\[\]\(\)\~\>\#\+\-\=\|\{\}\.\!])', '\\$1'
$prNumber = "6"
$action = "closed" -replace '([_\*\[\]\(\)\~\>\#\+\-\=\|\{\}\.\!])', '\\$1'

$message = @"
📣 *Pull Request Activity*
👤 Actor: $actor
🔧 Action: $action
📂 Repo: $repo
🔗 PR: [View PR](https://github.com/$repo/pull/$prNumber)
"@

Invoke-RestMethod -Uri "https://api.telegram.org/bot$env:TELEGRAM_TOKEN/sendMessage" `
  -Method Post `
  -ContentType "application/x-www-form-urlencoded" `
  -Body @{
  chat_id = "$env:TELEGRAM_CHAT_ID"
  text     = $message
  parse_mode = "MarkdownV2"
  }

if ((Test-Path -LiteralPath variable:\LASTEXITCODE)) { exit $LASTEXITCODE }