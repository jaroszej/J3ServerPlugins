# J3ServerPlugins

## Commands

*/position*
aliases = [pos, where]
args = [Player, Channel]

- Player = Username of the player who's position to return
- Channel = 0 (default) to whisper to self, 1 to broadcast to server
```
$ /position

# return statement is whispered
# You are at x: -200, y: 60, z: 200
--------------------------------------------------  
  
$ /position Username 1

# return statement is broadcasted
# Username is at x: -200, y: 60, z: 200
```
---