# NAOMI-tools
Some file processing tools - initially useful for NAOMI file deletes; ultimately they will be general DFramework utils


The first tool, Deletefiles will delete files only (non recursive initially)

Depending on parameters passed:


DeleteFiles						Delete all files in the  current directory (caution)

DeleteFiles [path]					Delete all files in the  specified directory 

DeleteFiles [path] [qty]				Delete all files in the  specified directory older (-) or newer (+)
							than the unit: day, hour or min - default is hour)

DeleteFiles [path] [qty] [unit]				Delete all files in the  specified directory older (-) or newer (+)
							than the unit: day, hour or min specified as unit d, h or m)

DeleteFiles [path] [qty] [unit]	[ext]			Delete all files in the  specified directory older (-) or newer (+)
							than the unit: day, hour or min specified as unit d, h or m) but only with 
							given file extension



Spcial case:


DeleteFiles [path] [ext]				Delete all files in the  specified directory o but only with 
							given file extension ... code to be added in next commit