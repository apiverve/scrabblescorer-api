from setuptools import setup, find_packages

setup(
    name='apiverve_scrabblewordscorer',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Scrabble Word Scorer calculates the official Scrabble score for any word across five languages. It provides the total base points, letter count, and point values for each individual letter.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/scrabblescorer?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
