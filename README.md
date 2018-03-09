# vaasm
Hi,

This the first read me file

git commit -m "first commit"
*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"

to set your account's default identity.
Omit --global to set the identity only in this repository.

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
 
 C:\Users\vaasm>git push -u origin master
To https://github.com/shenbagamManik/vaasm.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/shenbagamManik/vaasm.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

C:\Users\vaasm>git pull
warning: no common commits
remote: Counting objects: 6, done.
remote: Compressing objects: 100% (4/4), done.
remote: Total 6 (delta 0), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (6/6), done.
From https://github.com/shenbagamManik/vaasm
 * [new branch]      master     -> origin/master
There is no tracking information for the current branch.
Please specify which branch you want to merge with.
See git-pull(1) for details.


C:\Users\vaasm>git push -u origin master
error: src refspec master does not match any.
error: failed to push some refs to 'https://github.com/shenbagamManik/vaasm.git'
    git pull <remote> <branch>
