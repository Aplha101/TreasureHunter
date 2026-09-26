javac -d bin src/entity/*.java src/main/*.java src/tile/*.java

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation failed."
    exit
}
a
java -cp "bin;res" main.Main