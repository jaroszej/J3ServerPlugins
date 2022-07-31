# J3ServerPlugins v1.0.2

## Commands

---

*/position*

aliases = [pos, where]

args = [Player, Channel]

- Player = Username of the player whose position to return
- Channel = 0 (default) to whisper to self, 1 to broadcast to server
```
$ /position

# return statement is whispered
> You are at x: -200, y: 60, z: 200
--------------------------------------------------  
  
$ /position Username 1

# return statement is broadcasted
> Username is at x: -200, y: 60, z: 200
```
---

## Events

---

### Death Location
On death, player will be whispered their death coordinates.

### EXP Lost on Death
On death, player will be whispered the amount of EXP lost.

### Automatic Work Tool Replacement
Replace broken items if a similar item is in player inventory  