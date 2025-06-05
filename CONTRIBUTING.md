# Contributing to This Is Magic

## Git Branching Strategy

We follow a modified Git Flow workflow:

### Main Branches
- `master` - Production-ready code only. Contains released versions.
- `develop` - Main development branch. Features are merged here after review.

### Supporting Branches
- `feature/*` - For new features and non-emergency bug fixes
- `release/*` - For preparing new production releases
- `hotfix/*` - For critical bug fixes that must be deployed immediately

## Workflow

### Feature Development
1. Create a feature branch from `develop`:
   ```bash
   git checkout develop
   git pull origin develop
   git checkout -b feature/your-feature-name
   ```

2. Work on your feature:
   ```bash
   git add .
   git commit -m "Description of changes"
   ```

3. Push your feature branch:
   ```bash
   git push -u origin feature/your-feature-name
   ```

4. Create a Pull Request to merge into `develop`

### Release Process
1. Create a release branch from `develop`:
   ```bash
   git checkout develop
   git pull origin develop
   git checkout -b release/v1.x.x
   ```

2. Make release-specific changes (version numbers, etc.)
3. Create a Pull Request to merge into `master`
4. After merging to `master`, merge back into `develop`

### Hotfix Process
1. Create a hotfix branch from `master`:
   ```bash
   git checkout master
   git pull origin master
   git checkout -b hotfix/issue-description
   ```

2. Fix the issue
3. Create Pull Requests to merge into both `master` and `develop`

## Commit Messages

- Use clear, descriptive commit messages
- Start with a verb in present tense
- Example: "Add magic wand crafting system"

## Code Review Process

1. All changes must be reviewed through Pull Requests
2. At least one approval is required
3. All tests must pass
4. Code must follow project style guidelines

## Version Tagging

After merging to master, tag the release:
```bash
git checkout master
git pull origin master
git tag -a v1.x.x -m "Version 1.x.x"
git push origin v1.x.x
``` 