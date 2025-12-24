SUPAH ROOMBA




```mermaid
stateDiagram-v2
  [*] --> IDLE: start
  IDLE --> DRIVE_FORWARD: start
  DRIVE_FORWARD --> AVOIDING: obstacle?
  AVOIDING --> DRIVE_FORWARD: clear
  DRIVE_FORWARD --> IDLE: stop
  IDLE --> [*]: exit / shutdown
```
