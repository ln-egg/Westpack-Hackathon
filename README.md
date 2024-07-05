# Westpack-Hackathon

## Clone Repository
1. Open IntelliJ IDEA
2. `File > New > Project from Version Control`
3. or `Get from VCS`
4. Copy "https://github.com/ln-egg/cab302-mmlt.git" into URL

## Committing Work
1. Run `git add .` to stage all files
2. Then `git commit -m "Message"` with a message on what was changed[<sup>1</sup>](README.md#notes)
3. Then run `git push`
4. If it's the first time the branch is being pushed after being created then run `git push --set-upstream origin <branch>`

## Merging with main
1. Run `git checkout main` to go to the main branch
2. Then `git pull` to update your local repository[<sup>2</sup>](README.md#notes)
3. Then run `git checkout <branch-name>` for the branch you wish to update
4. Then run `git merge main` to update the branch with the changes made in main
5. Then run `git push` to update the branch on the remote repository

## Collaborating
- Use `// TODO Now:` and `// TODO Later:` comments to show others what you are working on and what needs to be completed
- Do not merge branches directly from the console, instead make a pull request on GitHub
- Commit and push work onto the remote repository often to ensure the repository is always up-to-date in the case the program fails and a revert is required

## Installing the Libraries
1. `File > Project Structure`
2. Go to the Libraries tab
3. Click on the `+` icon
4. Then select `From Maven...`
5. Type `library-name` into the search bar
    - Libraries
        - `de.jensd:fontawesomefx:8.2`
        - `org.xerial:sqlite-jdbc:3.36.0.3`
6. Then click `OK`
7. Repeat steps 5 and 6 for all libraries

## Changing a branch name
1. Run `git branch -m <old-name> <new-name>` to change the name of the local branch
2. Run `git push origin --delete <old-name>` or `git push origin :<old-name>` to delete the branch on the remote repository
3. Run `git branch --unset-upstream <new-name>` to rename the upstream name
4. Run `git push` to push onto remote repository
5. Run `git push --set-upstream origin <new-name>` to reset the upstream branch

## Git Commands
- Run `git pull` to update your local repository[<sup>2</sup>](README.md#notes)
- Run `git restore .` to remove all changes that haven't been commited
- Run `git fetch` on the main branch to fetch all branches
- Run `git branch <new-branch>` to create a new branch
- Run `git checkout <branch>` to enter branch
- Run `git checkout -b <new-branch>` to create a new branch and automatically enter the branch
- Run `git stash` to stash uncommitted work inside a branch
- Run `git stash pop` to pop work that was previously stashed
- Run `git revert <commitHash>` to revert to a working commit[<sup>1</sup>](README.md#notes)
- Run `git revert -m 1 <commitHash>` to revert to a working commit and removing the merge[<sup>1</sup>](README.md#notes)
- Run `git log` to view commit log
- Run `git status` to view if there are any uncommitted changes
- Under no circumstances should `git reset` be used[<sup>3</sup>](README.md#notes)

## NOTES
<sup>1</sup> This command can cause merge conflicts and will require them to be resolved before continuing

<sup>2</sup> This command should be run regularly to get updates that are made to the remote repository, especially if more than one person is working on the same branch at a time

<sup>3</sup> This command can rewrite history, additionally if used incorrectly can delete a whole repository which is irreversible