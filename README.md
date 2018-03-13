# vaasm
git commit -m "first commit"
*** Please tell me who you are.

git config --global user.name shenbagammanik
git config --global user.email "mshen5691@gmail.com"

git config --list

git status

git add index_old.jsp

git commit -m index_old.jsp
[master (root-commit) 448dfea] index_old.jsp
 2 files changed, 34 insertions(+)
 create mode 100644 README.md
 create mode 100644 index_old.jsp
 
C:\shen\project.git>git clone https://github.com/shenbagamManik/vaasm
Cloning into 'vaasm'...
remote: Counting objects: 9, done.
remote: Compressing objects: 100% (7/7), done.
remote: Total 9 (delta 0), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (9/9), done.

C:\shen\project.git>cd vaasm
C:\shen\project.git\vaasm>dir
C:\shen\project.git\vaasm>git add index_old.jsp
C:\shen\project.git\vaasm>git push
C:\shen\project.git\vaasm>git status
On branch master
Your branch is up to date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)
        new file:   index_old.jsp
C:\shen\project.git\vaasm>git commit -am  "Initial commit"
[master 96bfe6d] Initial commit
 1 file changed, 33 insertions(+)
 create mode 100644 index_old.jsp
  
  C:\shen\project.git\vaasm>git pull --rebase
Current branch master is up to date.

C:\shen\project.git\vaasm>git push
Counting objects: 3, done.

//////create a new branch//////

git checkout -b poject-rep
git checkout -b project-rep master

C:\shen\project.git\vaasm>git branch
  master
  poject-rep
* project-rep

git add Testwebsiteproject

git commit -am "new branch"
[project-rep db3593e] new branch
 51 files changed, 0 insertions(+), 0 deletions(-)
 
 git push --set-upstream origin project-rep
 
 git push
Everything up-to-date

