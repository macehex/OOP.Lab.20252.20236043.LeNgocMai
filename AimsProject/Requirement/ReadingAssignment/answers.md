1.3 Compare Swing and AWT elements:
Programming with AWT and Swing is quite similar (similar elements including container/components, and
event-handling). However, there are some differences that you need to note:
# Compare the top-level containers in Swing and AWT
    - AWTAccumulator extends from Frame which is a top-level AWT window with a title border     
    - SwingAccumulator extends from JFrame which is a Swing top-level container that's more flexible and consistent in appearance.
# Compare the class name of components in AWT and the corresponding class’s name in Swing
    
| AWT Component | Swing Component |
|---------------|-----------------|
| TextField     | JTextField      |  
| Label         | JLabel          |


# Compare the event-handling of Swing and AWT applications
The event handling seems to be very similar!
    - Both use ActionListener thats registered with addActionListener()

- ->The resulting appearances of the applications developed using Swing and AWT might be different as well.
Make comparisons.
![img_1.png](img_1.png)

- The AWT accumulator have harsher line and separation between Fields and the font doesn't look as refined as the font of
Swing accumulator.
- Swing have smoother Uis and aligned components that blends well together

