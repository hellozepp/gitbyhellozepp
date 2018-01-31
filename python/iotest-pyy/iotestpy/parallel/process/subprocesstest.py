import subprocess

subprocess.run("echo aaa",shell=True)

# =======================================================================
print("=======================================================================")
p=subprocess.run("ls /",shell=True,stdout=subprocess.PIPE)
print(p.stdout.decode("utf-8"))

# =======================================================================
print("=======================================================================")
p=subprocess.run(["python3","./testpy.py"],input = b"xxx\n",stdout=subprocess.PIPE)
print(p.stdout.decode("utf-8"))

# =======================================================================
print("=======================================================================")

data=b"test\n"
p=subprocess.Popen(["python3","./testpy.py"],stdin=subprocess.PIPE,stdout=subprocess.PIPE)
res=p.communicate(input=data)
print(res[0].decode("utf-8"))