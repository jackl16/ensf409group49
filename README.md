# ensf409group49

Authors: Marco, Jack, Minseung, Sina

1. Make sure to add your Unit Test Files into your .gitignore to avoid uploading several unnecessary test files to the main branch. 
   Do that for all your personal files and documents that are not source codes (.class files created when testing, etc)
UPDATE: .gitignore file has been updated to exclude all .class and .jar files from being tracked. Only .java source codes
   will be tracked to commit now.
2. Fork this repository to work on.
3. Create your own branch to work on even on your forked repository to make it easier to keep track of the pull requests
4. Leave meaningful pull request comments.


=======
5. Steps to update your fork:
   - git remote add upstream https://github.com/ItsMarcoMSF/ensf409group49 (only have to do one time)
   - git checkout main
   - git fetch upstream
   - git merge upstream/main
   - git checkout <your branch>
   - git merge main
     (Now your local is updated)
   - git checkout main
   - git push --all origin
     (Now all branches are updated on github)
6. Steps to upload your new files or changed files to the main fork:
   - Make sure you're working on your branch
   - git add <file you want to upload>
   - git commit -m "add your message here (make it meaningful)"
   - git push
   - After this go on to github and navigate to your branches and submit a pull request to ItsMarcoMSF/main.

