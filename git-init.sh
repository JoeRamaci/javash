git init
echo 'Enter GitHub email email'
read gitHubEmail
git config user.email "$gitHubEmail"
echo 'Enter GitHub username'
read gitHubName
git config user.name "gitHubName"
git add .
echo 'Enter a commit comment'
read commitComment
git commit -m "$commitComment"
echo 'Enter the remote origin URL'
read url
git remote add origin "$url"
git branch -M main
git push origin main
