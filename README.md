# OOP2-GROUP-PROJECT
<img width="1200" height="980" alt="ArcadeGameHub_v3" src="https://github.com/user-attachments/assets/ee9046c2-f975-4542-8598-c26be885fd84" />
<svg xmlns="http://www.w3.org/2000/svg" width="1200" height="980" viewBox="0 0 1200 980" font-family="Arial, sans-serif">

  <defs>
    <marker id="arrow" markerWidth="10" markerHeight="10" refX="8" refY="3.5" orient="auto">
      <path d="M0,0 L0,7 L10,3.5 z" fill="#1a1a1a"/>
    </marker>
    <marker id="arrowBlue" markerWidth="10" markerHeight="10" refX="8" refY="3.5" orient="auto">
      <path d="M0,0 L0,7 L10,3.5 z" fill="#1565c0"/>
    </marker>
    <marker id="arrowPurple" markerWidth="10" markerHeight="10" refX="8" refY="3.5" orient="auto">
      <path d="M0,0 L0,7 L10,3.5 z" fill="#6a1b9a"/>
    </marker>
    <marker id="arrowGray" markerWidth="10" markerHeight="10" refX="8" refY="3.5" orient="auto">
      <path d="M0,0 L0,7 L10,3.5 z" fill="#757575"/>
    </marker>
    <marker id="arrowGreen" markerWidth="10" markerHeight="10" refX="8" refY="3.5" orient="auto">
      <path d="M0,0 L0,7 L10,3.5 z" fill="#2e7d32"/>
    </marker>
  </defs>

  <!-- White Background -->
  <rect width="1200" height="980" fill="#ffffff"/>

  <!-- ===== TITLE ===== -->
  <text x="600" y="38" text-anchor="middle" font-size="24" font-weight="bold" fill="#111111" letter-spacing="2">ArcadeGameHub — Use Case Diagram</text>
  <line x1="60" y1="52" x2="1140" y2="52" stroke="#333333" stroke-width="1.5"/>

  <!-- ===== SYSTEM BOUNDARY ===== -->
  <rect x="210" y="68" width="820" height="858" rx="6"
        fill="#fafafa" stroke="#222222" stroke-width="2.2"/>
  <text x="620" y="90" text-anchor="middle" font-size="12" fill="#444444" font-style="italic">« system »  ArcadeGameHub</text>

  <!-- ===== ACTOR: PLAYER 1 (left) ===== -->
  <circle cx="90" cy="280" r="24" fill="none" stroke="#111111" stroke-width="2.2"/>
  <line x1="90" y1="304" x2="90" y2="368" stroke="#111111" stroke-width="2.2"/>
  <line x1="55" y1="330" x2="125" y2="330" stroke="#111111" stroke-width="2.2"/>
  <line x1="90" y1="368" x2="63"  y2="405" stroke="#111111" stroke-width="2.2"/>
  <line x1="90" y1="368" x2="117" y2="405" stroke="#111111" stroke-width="2.2"/>
  <text x="90" y="428" text-anchor="middle" font-size="14" font-weight="bold" fill="#111111">Player 1</text>
  <text x="90" y="444" text-anchor="middle" font-size="11" fill="#555555">« actor »</text>

  <!-- ===== ACTOR: PLAYER 2 (left, below) ===== -->
  <circle cx="90" cy="620" r="24" fill="none" stroke="#1565c0" stroke-width="2.2"/>
  <line x1="90" y1="644" x2="90" y2="708" stroke="#1565c0" stroke-width="2.2"/>
  <line x1="55" y1="670" x2="125" y2="670" stroke="#1565c0" stroke-width="2.2"/>
  <line x1="90" y1="708" x2="63"  y2="745" stroke="#1565c0" stroke-width="2.2"/>
  <line x1="90" y1="708" x2="117" y2="745" stroke="#1565c0" stroke-width="2.2"/>
  <text x="90" y="768" text-anchor="middle" font-size="14" font-weight="bold" fill="#1565c0">Player 2</text>
  <text x="90" y="784" text-anchor="middle" font-size="11" fill="#1976d2">« actor »</text>
  <!-- 2-player note -->
  <rect x="28" y="796" width="126" height="28" rx="4" fill="#e3f2fd" stroke="#1565c0" stroke-width="1"/>
  <text x="91" y="814" text-anchor="middle" font-size="10" fill="#0d47a1">Optional / 2-player games</text>

  <!-- ===== LEFT COLUMN: MAIN USE CASES ===== -->

  <!-- UC1: View Main Menu -->
  <ellipse cx="368" cy="138" rx="115" ry="30" fill="#ffffff" stroke="#111111" stroke-width="2"/>
  <text x="368" y="134" text-anchor="middle" font-size="13" font-weight="bold" fill="#111111">View Main Menu</text>
  <text x="368" y="150" text-anchor="middle" font-size="11" fill="#555555">(Hub Lobby)</text>

  <!-- UC2: Select Mini Game -->
  <ellipse cx="368" cy="228" rx="115" ry="30" fill="#ffffff" stroke="#111111" stroke-width="2"/>
  <text x="368" y="224" text-anchor="middle" font-size="13" font-weight="bold" fill="#111111">Select Mini Game</text>
  <text x="368" y="240" text-anchor="middle" font-size="11" fill="#555555">(Choose from list)</text>

  <!-- UC3: Select Mode (1P or 2P) -->
  <ellipse cx="368" cy="318" rx="115" ry="30" fill="#fff8e1" stroke="#f57f17" stroke-width="2"/>
  <text x="368" y="314" text-anchor="middle" font-size="13" font-weight="bold" fill="#e65100">Select Mode</text>
  <text x="368" y="330" text-anchor="middle" font-size="11" fill="#ef6c00">(1 Player / 2 Player)</text>

  <!-- UC4: View Game Rules -->
  <ellipse cx="368" cy="408" rx="115" ry="30" fill="#f5f5f5" stroke="#777777" stroke-width="1.6" stroke-dasharray="6,3"/>
  <text x="368" y="404" text-anchor="middle" font-size="13" fill="#333333">View Game Rules</text>
  <text x="368" y="420" text-anchor="middle" font-size="11" fill="#777777">(Optional)</text>

  <!-- UC5: Play Game -->
  <ellipse cx="368" cy="508" rx="115" ry="30" fill="#e3f2fd" stroke="#1565c0" stroke-width="2.5"/>
  <text x="368" y="512" text-anchor="middle" font-size="14" font-weight="bold" fill="#0d47a1">Play Game</text>

  <!-- UC6: View Score / Result -->
  <ellipse cx="368" cy="608" rx="115" ry="30" fill="#ffffff" stroke="#111111" stroke-width="2"/>
  <text x="368" y="604" text-anchor="middle" font-size="13" font-weight="bold" fill="#111111">View Score / Result</text>
  <text x="368" y="620" text-anchor="middle" font-size="11" fill="#555555">(Win / Lose / Draw)</text>

  <!-- UC7: Play Again -->
  <ellipse cx="368" cy="708" rx="115" ry="30" fill="#f5f5f5" stroke="#777777" stroke-width="1.6" stroke-dasharray="6,3"/>
  <text x="368" y="704" text-anchor="middle" font-size="13" fill="#333333">Play Again</text>
  <text x="368" y="720" text-anchor="middle" font-size="11" fill="#777777">(Restart round)</text>

  <!-- UC8: Exit to Main Menu -->
  <ellipse cx="368" cy="798" rx="115" ry="30" fill="#f5f5f5" stroke="#777777" stroke-width="1.6" stroke-dasharray="6,3"/>
  <text x="368" y="794" text-anchor="middle" font-size="13" fill="#333333">Exit to Main Menu</text>
  <text x="368" y="810" text-anchor="middle" font-size="11" fill="#777777">(Back to Hub)</text>

  <!-- ===== MINI GAME BOXES ===== -->

  <!-- Section label -->
  <text x="740" y="116" text-anchor="middle" font-size="11" fill="#888888" letter-spacing="2">— MINI GAMES —</text>
  <!-- 1P label -->
  <rect x="582" y="122" width="60" height="18" rx="4" fill="#e8f5e9" stroke="#2e7d32" stroke-width="1"/>
  <text x="612" y="135" text-anchor="middle" font-size="10" fill="#2e7d32" font-weight="bold">1 Player</text>
  <!-- 2P label -->
  <rect x="858" y="122" width="60" height="18" rx="4" fill="#e3f2fd" stroke="#1565c0" stroke-width="1"/>
  <text x="888" y="135" text-anchor="middle" font-size="10" fill="#1565c0" font-weight="bold">2 Players</text>

  <!-- ROW 1: GuessGame (1P) -->
  <rect x="568" y="148" width="170" height="62" rx="10" fill="#e8f5e9" stroke="#2e7d32" stroke-width="2"/>
  <text x="653" y="168" text-anchor="middle" font-size="10" fill="#2e7d32" font-style="italic">« extend »</text>
  <text x="653" y="184" text-anchor="middle" font-size="14" font-weight="bold" fill="#1b5e20">GuessGame</text>
  <text x="653" y="200" text-anchor="middle" font-size="10" fill="#388e3c">Guess the number · 1P</text>

  <!-- ROW 2: QuizGame (1P) -->
  <rect x="568" y="238" width="170" height="62" rx="10" fill="#fff8e1" stroke="#f57f17" stroke-width="2"/>
  <text x="653" y="258" text-anchor="middle" font-size="10" fill="#f57f17" font-style="italic">« extend »</text>
  <text x="653" y="274" text-anchor="middle" font-size="14" font-weight="bold" fill="#e65100">QuizGame</text>
  <text x="653" y="290" text-anchor="middle" font-size="10" fill="#ef6c00">Answer questions · 1P</text>

  <!-- ROW 3: Memory Match (1P) -->
  <rect x="568" y="328" width="170" height="62" rx="10" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="2"/>
  <text x="653" y="348" text-anchor="middle" font-size="10" fill="#6a1b9a" font-style="italic">« extend »</text>
  <text x="653" y="364" text-anchor="middle" font-size="14" font-weight="bold" fill="#4a148c">MemoryMatch</text>
  <text x="653" y="380" text-anchor="middle" font-size="10" fill="#7b1fa2">Match card pairs · 1P</text>

  <!-- ROW 4: Minefield (1P) -->
  <rect x="568" y="418" width="170" height="62" rx="10" fill="#fce4ec" stroke="#c62828" stroke-width="2"/>
  <text x="653" y="438" text-anchor="middle" font-size="10" fill="#c62828" font-style="italic">« extend »</text>
  <text x="653" y="454" text-anchor="middle" font-size="14" font-weight="bold" fill="#b71c1c">Minefield</text>
  <text x="653" y="470" text-anchor="middle" font-size="10" fill="#d32f2f">Avoid mines · 1P</text>

  <!-- ROW 5: RPSGame (1P or 2P) -->
  <rect x="568" y="508" width="170" height="62" rx="10" fill="#e0f7fa" stroke="#00838f" stroke-width="2"/>
  <text x="653" y="528" text-anchor="middle" font-size="10" fill="#00838f" font-style="italic">« extend »</text>
  <text x="653" y="544" text-anchor="middle" font-size="14" font-weight="bold" fill="#006064">RPSGame</text>
  <text x="653" y="560" text-anchor="middle" font-size="10" fill="#00838f">Rock Paper Scissors · 1P/2P</text>

  <!-- ROW 6: Tic-Tac-Toe (1P or 2P) -->
  <rect x="568" y="598" width="170" height="62" rx="10" fill="#e8eaf6" stroke="#283593" stroke-width="2"/>
  <text x="653" y="618" text-anchor="middle" font-size="10" fill="#283593" font-style="italic">« extend »</text>
  <text x="653" y="634" text-anchor="middle" font-size="14" font-weight="bold" fill="#1a237e">Tic-Tac-Toe</text>
  <text x="653" y="650" text-anchor="middle" font-size="10" fill="#3949ab">X vs O board · 1P/2P</text>

  <!-- ===== DETAIL BOXES (far right) ===== -->

  <!-- GuessGame -->
  <rect x="772" y="148" width="232" height="62" rx="6" fill="#f9fbe7" stroke="#aed581" stroke-width="1.5"/>
  <text x="888" y="168" text-anchor="middle" font-size="10" fill="#33691e">• Enter a number guess</text>
  <text x="888" y="182" text-anchor="middle" font-size="10" fill="#33691e">• Get higher / lower hint</text>
  <text x="888" y="196" text-anchor="middle" font-size="10" fill="#33691e">• Win if guess is correct</text>

  <!-- QuizGame -->
  <rect x="772" y="238" width="232" height="62" rx="6" fill="#fffde7" stroke="#ffd54f" stroke-width="1.5"/>
  <text x="888" y="258" text-anchor="middle" font-size="10" fill="#827717">• Read question prompt</text>
  <text x="888" y="272" text-anchor="middle" font-size="10" fill="#827717">• Choose answer A / B / C / D</text>
  <text x="888" y="286" text-anchor="middle" font-size="10" fill="#827717">• See result per question</text>

  <!-- MemoryMatch -->
  <rect x="772" y="328" width="232" height="62" rx="6" fill="#f8f0fc" stroke="#ce93d8" stroke-width="1.5"/>
  <text x="888" y="348" text-anchor="middle" font-size="10" fill="#4a148c">• Flip 2 cards per turn</text>
  <text x="888" y="362" text-anchor="middle" font-size="10" fill="#4a148c">• Match pairs to score</text>
  <text x="888" y="376" text-anchor="middle" font-size="10" fill="#4a148c">• Win when all matched</text>

  <!-- Minefield -->
  <rect x="772" y="418" width="232" height="62" rx="6" fill="#fff3e0" stroke="#ffb74d" stroke-width="1.5"/>
  <text x="888" y="438" text-anchor="middle" font-size="10" fill="#bf360c">• Click tiles to reveal</text>
  <text x="888" y="452" text-anchor="middle" font-size="10" fill="#bf360c">• Avoid hidden mines</text>
  <text x="888" y="466" text-anchor="middle" font-size="10" fill="#bf360c">• Win by clearing safe tiles</text>

  <!-- RPSGame -->
  <rect x="772" y="508" width="232" height="62" rx="6" fill="#e0f7fa" stroke="#80deea" stroke-width="1.5"/>
  <text x="888" y="528" text-anchor="middle" font-size="10" fill="#006064">• Pick Rock / Paper / Scissors</text>
  <text x="888" y="542" text-anchor="middle" font-size="10" fill="#006064">• 1P: vs CPU  |  2P: vs Player 2</text>
  <text x="888" y="556" text-anchor="middle" font-size="10" fill="#006064">• Win / Lose / Draw shown</text>

  <!-- Tic-Tac-Toe -->
  <rect x="772" y="598" width="232" height="62" rx="6" fill="#e8eaf6" stroke="#9fa8da" stroke-width="1.5"/>
  <text x="888" y="618" text-anchor="middle" font-size="10" fill="#1a237e">• Take turns placing X or O</text>
  <text x="888" y="632" text-anchor="middle" font-size="10" fill="#1a237e">• 1P: vs CPU  |  2P: vs Player 2</text>
  <text x="888" y="646" text-anchor="middle" font-size="10" fill="#1a237e">• Win by 3-in-a-row</text>

  <!-- Lines: game boxes → detail boxes -->
  <line x1="738" y1="179" x2="772" y2="179" stroke="#bbbbbb" stroke-width="1.2" stroke-dasharray="3,3"/>
  <line x1="738" y1="269" x2="772" y2="269" stroke="#bbbbbb" stroke-width="1.2" stroke-dasharray="3,3"/>
  <line x1="738" y1="359" x2="772" y2="359" stroke="#bbbbbb" stroke-width="1.2" stroke-dasharray="3,3"/>
  <line x1="738" y1="449" x2="772" y2="449" stroke="#bbbbbb" stroke-width="1.2" stroke-dasharray="3,3"/>
  <line x1="738" y1="539" x2="772" y2="539" stroke="#bbbbbb" stroke-width="1.2" stroke-dasharray="3,3"/>
  <line x1="738" y1="629" x2="772" y2="629" stroke="#bbbbbb" stroke-width="1.2" stroke-dasharray="3,3"/>

  <!-- ===== PLAYER 1 → USE CASES ===== -->
  <line x1="114" y1="262" x2="252" y2="148" stroke="#111111" stroke-width="1.8" marker-end="url(#arrow)"/>
  <line x1="114" y1="272" x2="252" y2="235" stroke="#111111" stroke-width="1.8" marker-end="url(#arrow)"/>
  <line x1="114" y1="290" x2="252" y2="322" stroke="#111111" stroke-width="1.8" marker-end="url(#arrow)"/>
  <line x1="114" y1="308" x2="252" y2="412" stroke="#888888" stroke-width="1.3" stroke-dasharray="5,4" marker-end="url(#arrowGray)"/>
  <line x1="114" y1="325" x2="252" y2="510" stroke="#111111" stroke-width="1.8" marker-end="url(#arrow)"/>
  <line x1="114" y1="340" x2="252" y2="610" stroke="#111111" stroke-width="1.8" marker-end="url(#arrow)"/>
  <line x1="114" y1="355" x2="252" y2="708" stroke="#888888" stroke-width="1.3" stroke-dasharray="5,4" marker-end="url(#arrowGray)"/>
  <line x1="114" y1="368" x2="252" y2="798" stroke="#888888" stroke-width="1.3" stroke-dasharray="5,4" marker-end="url(#arrowGray)"/>

  <!-- ===== PLAYER 2 → 2P GAMES ONLY ===== -->
  <!-- Player 2 → Play Game -->
  <line x1="114" y1="610" x2="252" y2="510" stroke="#1565c0" stroke-width="1.8" marker-end="url(#arrowBlue)"/>
  <!-- Player 2 → View Score -->
  <line x1="114" y1="630" x2="252" y2="612" stroke="#1565c0" stroke-width="1.8" marker-end="url(#arrowBlue)"/>

  <!-- ===== INCLUDE / EXTEND RELATIONSHIPS ===== -->

  <!-- View Main Menu «include» Select Mini Game -->
  <line x1="368" y1="168" x2="368" y2="198" stroke="#6a1b9a" stroke-width="1.6" stroke-dasharray="6,4" marker-end="url(#arrowPurple)"/>
  <rect x="375" y="176" width="68" height="16" rx="3" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="1"/>
  <text x="409" y="188" text-anchor="middle" font-size="10" fill="#6a1b9a">« include »</text>

  <!-- Select Mini Game «include» Select Mode -->
  <line x1="368" y1="258" x2="368" y2="288" stroke="#6a1b9a" stroke-width="1.6" stroke-dasharray="6,4" marker-end="url(#arrowPurple)"/>
  <rect x="375" y="266" width="68" height="16" rx="3" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="1"/>
  <text x="409" y="278" text-anchor="middle" font-size="10" fill="#6a1b9a">« include »</text>

  <!-- Select Mode «include» Play Game -->
  <line x1="368" y1="348" x2="368" y2="478" stroke="#6a1b9a" stroke-width="1.6" stroke-dasharray="6,4" marker-end="url(#arrowPurple)"/>
  <rect x="375" y="405" width="68" height="16" rx="3" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="1"/>
  <text x="409" y="417" text-anchor="middle" font-size="10" fill="#6a1b9a">« include »</text>

  <!-- Play Game «include» View Score -->
  <line x1="368" y1="538" x2="368" y2="578" stroke="#6a1b9a" stroke-width="1.6" stroke-dasharray="6,4" marker-end="url(#arrowPurple)"/>
  <rect x="375" y="550" width="68" height="16" rx="3" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="1"/>
  <text x="409" y="562" text-anchor="middle" font-size="10" fill="#6a1b9a">« include »</text>

  <!-- View Score «extend» Play Again -->
  <line x1="368" y1="638" x2="368" y2="678" stroke="#888888" stroke-width="1.4" stroke-dasharray="6,4" marker-end="url(#arrowGray)"/>
  <rect x="375" y="650" width="68" height="16" rx="3" fill="#f5f5f5" stroke="#888888" stroke-width="1"/>
  <text x="409" y="662" text-anchor="middle" font-size="10" fill="#555555">« extend »</text>

  <!-- View Score «extend» Exit -->
  <line x1="318" y1="638" x2="318" y2="768" stroke="#888888" stroke-width="1.4" stroke-dasharray="6,4" marker-end="url(#arrowGray)"/>
  <rect x="224" y="698" width="68" height="16" rx="3" fill="#f5f5f5" stroke="#888888" stroke-width="1"/>
  <text x="258" y="710" text-anchor="middle" font-size="10" fill="#555555">« extend »</text>

  <!-- Play Again loops back to Play Game -->
  <path d="M 253 708 C 196 708 196 508 253 508" fill="none" stroke="#888888" stroke-width="1.4" stroke-dasharray="5,4" marker-end="url(#arrowGray)"/>
  <rect x="192" y="600" width="44" height="16" rx="3" fill="#f5f5f5" stroke="#888888" stroke-width="1"/>
  <text x="214" y="612" text-anchor="middle" font-size="9" fill="#555555">loop</text>

  <!-- Play Game «extend» each mini game -->
  <line x1="483" y1="498" x2="568" y2="179" stroke="#1565c0" stroke-width="1.5" stroke-dasharray="6,4" marker-end="url(#arrowBlue)"/>
  <line x1="483" y1="502" x2="568" y2="269" stroke="#1565c0" stroke-width="1.5" stroke-dasharray="6,4" marker-end="url(#arrowBlue)"/>
  <line x1="483" y1="508" x2="568" y2="359" stroke="#1565c0" stroke-width="1.5" stroke-dasharray="6,4" marker-end="url(#arrowBlue)"/>
  <line x1="483" y1="514" x2="568" y2="449" stroke="#1565c0" stroke-width="1.5" stroke-dasharray="6,4" marker-end="url(#arrowBlue)"/>
  <line x1="483" y1="520" x2="568" y2="539" stroke="#1565c0" stroke-width="1.5" stroke-dasharray="6,4" marker-end="url(#arrowBlue)"/>
  <line x1="483" y1="526" x2="568" y2="629" stroke="#1565c0" stroke-width="1.5" stroke-dasharray="6,4" marker-end="url(#arrowBlue)"/>

  <!-- «extend» label on the fan of lines -->
  <rect x="504" y="488" width="56" height="16" rx="3" fill="#e3f2fd" stroke="#1565c0" stroke-width="1"/>
  <text x="532" y="500" text-anchor="middle" font-size="10" fill="#1565c0">« extend »</text>

  <!-- 2P badge on RPS and Tic-Tac-Toe -->
  <rect x="700" y="512" width="26" height="16" rx="3" fill="#1565c0"/>
  <text x="713" y="524" text-anchor="middle" font-size="9" fill="#ffffff" font-weight="bold">2P</text>
  <rect x="700" y="602" width="26" height="16" rx="3" fill="#1565c0"/>
  <text x="713" y="614" text-anchor="middle" font-size="9" fill="#ffffff" font-weight="bold">2P</text>

  <!-- ===== LEGEND ===== -->
  <rect x="220" y="940" width="820" height="34" rx="6"
        fill="#f9f9f9" stroke="#cccccc" stroke-width="1.2"/>

  <line x1="240" y1="957" x2="272" y2="957" stroke="#111111" stroke-width="2"/>
  <polygon points="272,954 280,957 272,960" fill="#111111"/>
  <text x="285" y="961" font-size="11" fill="#111111">Association</text>

  <line x1="390" y1="957" x2="422" y2="957" stroke="#6a1b9a" stroke-width="1.6" stroke-dasharray="5,3"/>
  <polygon points="422,954 430,957 422,960" fill="#6a1b9a"/>
  <text x="435" y="961" font-size="11" fill="#6a1b9a">« include » (mandatory step)</text>

  <line x1="608" y1="957" x2="640" y2="957" stroke="#1565c0" stroke-width="1.6" stroke-dasharray="5,3"/>
  <polygon points="640,954 648,957 640,960" fill="#1565c0"/>
  <text x="653" y="961" font-size="11" fill="#1565c0">« extend » (game variant)</text>

  <rect x="820" y="949" width="26" height="16" rx="3" fill="#1565c0"/>
  <text x="833" y="961" text-anchor="middle" font-size="9" fill="#ffffff" font-weight="bold">2P</text>
  <text x="853" y="961" font-size="11" fill="#1565c0">2-Player game</text>

</svg>
<img width="1300" height="1020" alt="ArcadeGameHub_ClassDiagram" src="https://github.com/user-attachments/assets/a1cb4bc2-91d3-4d7c-bb86-613589b81828" />

<svg xmlns="http://www.w3.org/2000/svg" width="1300" height="1020" viewBox="0 0 1300 1020" font-family="Consolas, 'Courier New', monospace">

  <defs>
    <!-- Inheritance arrow (hollow triangle) -->
    <marker id="inherit" markerWidth="14" markerHeight="14" refX="12" refY="5" orient="auto">
      <path d="M0,0 L10,5 L0,10 Z" fill="#ffffff" stroke="#111111" stroke-width="1.4"/>
    </marker>
    <!-- Association arrow -->
    <marker id="assoc" markerWidth="10" markerHeight="10" refX="8" refY="3.5" orient="auto">
      <path d="M0,0 L0,7 L10,3.5 z" fill="#555555"/>
    </marker>
    <!-- Composition diamond -->
    <marker id="compose" markerWidth="14" markerHeight="10" refX="0" refY="5" orient="auto">
      <path d="M0,5 L6,0 L12,5 L6,10 Z" fill="#111111"/>
    </marker>
  </defs>

  <!-- White background -->
  <rect width="1300" height="1020" fill="#ffffff"/>

  <!-- Title -->
  <text x="650" y="36" text-anchor="middle" font-size="22" font-weight="bold" fill="#111111" letter-spacing="1">ArcadeGameHub — Class Diagram (Java OOP)</text>
  <line x1="60" y1="48" x2="1240" y2="48" stroke="#333333" stroke-width="1.5"/>

  <!-- ============================================================ -->
  <!-- LEGEND (top right) -->
  <!-- ============================================================ -->
  <rect x="1020" y="58" width="240" height="116" rx="6" fill="#f9f9f9" stroke="#cccccc" stroke-width="1.2"/>
  <text x="1140" y="76" text-anchor="middle" font-size="11" font-weight="bold" fill="#333333">LEGEND</text>
  <line x1="1036" y1="92" x2="1072" y2="92" stroke="#111111" stroke-width="2"/>
  <path d="M1068,88 L1078,92 L1068,96 Z" fill="#ffffff" stroke="#111111" stroke-width="1.4"/>
  <text x="1085" y="96" font-size="10" fill="#111111">Inheritance (extends)</text>
  <line x1="1036" y1="112" x2="1072" y2="112" stroke="#555555" stroke-width="1.5" stroke-dasharray="5,3"/>
  <path d="M1068,108 L1078,112 L1068,116 Z" fill="#555555"/>
  <text x="1085" y="116" font-size="10" fill="#333333">Association / uses</text>
  <path d="M1036,132 L1042,127 L1048,132 L1042,137 Z" fill="#111111"/>
  <line x1="1048" y1="132" x2="1072" y2="132" stroke="#111111" stroke-width="1.5"/>
  <text x="1085" y="136" font-size="10" fill="#333333">Composition (has-a)</text>
  <text x="1036" y="156" font-size="10" fill="#2e7d32">+ public</text>
  <text x="1086" y="156" font-size="10" fill="#c62828"># protected</text>
  <text x="1150" y="156" font-size="10" fill="#555555">- private</text>

  <!-- ============================================================ -->
  <!-- CLASS: ArcadeGameHub (Main entry) — top center -->
  <!-- ============================================================ -->
  <rect x="480" y="62" width="280" height="120" rx="4" fill="#e8eaf6" stroke="#283593" stroke-width="2.2"/>
  <!-- Header -->
  <rect x="480" y="62" width="280" height="30" rx="4" fill="#283593"/>
  <text x="620" y="82" text-anchor="middle" font-size="13" font-weight="bold" fill="#ffffff">ArcadeGameHub</text>
  <line x1="480" y1="92" x2="760" y2="92" stroke="#283593" stroke-width="1.5"/>
  <!-- Fields -->
  <text x="492" y="107" font-size="10" fill="#c62828"># List&lt;Game&gt; games</text>
  <text x="492" y="120" font-size="10" fill="#c62828"># Scanner scanner</text>
  <line x1="480" y1="128" x2="760" y2="128" stroke="#aaaaaa" stroke-width="1"/>
  <!-- Methods -->
  <text x="492" y="142" font-size="10" fill="#2e7d32">+ start() : void</text>
  <text x="492" y="155" font-size="10" fill="#2e7d32">+ showMenu() : void</text>
  <text x="492" y="168" font-size="10" fill="#2e7d32">+ selectGame() : void</text>

  <!-- ============================================================ -->
  <!-- ABSTRACT CLASS: Game — center -->
  <!-- ============================================================ -->
  <rect x="470" y="248" width="300" height="178" rx="4" fill="#fff8e1" stroke="#f57f17" stroke-width="2.2"/>
  <rect x="470" y="248" width="300" height="30" rx="4" fill="#f57f17"/>
  <text x="620" y="263" text-anchor="middle" font-size="11" fill="#ffffff" font-style="italic">« abstract »</text>
  <text x="620" y="277" text-anchor="middle" font-size="13" font-weight="bold" fill="#ffffff">Game</text>
  <line x1="470" y1="278" x2="770" y2="278" stroke="#f57f17" stroke-width="1.5"/>
  <!-- Fields -->
  <text x="482" y="294" font-size="10" fill="#c62828"># String gameName</text>
  <text x="482" y="308" font-size="10" fill="#c62828"># int playerCount</text>
  <text x="482" y="322" font-size="10" fill="#c62828"># Scanner scanner</text>
  <line x1="470" y1="330" x2="770" y2="330" stroke="#aaaaaa" stroke-width="1"/>
  <!-- Methods -->
  <text x="482" y="345" font-size="10" fill="#2e7d32">+ getGameName() : String</text>
  <text x="482" y="359" font-size="10" fill="#2e7d32">+ getPlayerCount() : int</text>
  <text x="482" y="373" font-size="10" fill="#2e7d32">+ showRules() : void</text>
  <text x="482" y="387" font-size="10" fill="#555555" font-style="italic">+ play() : void  « abstract »</text>
  <text x="482" y="401" font-size="10" fill="#555555" font-style="italic">+ checkWin() : boolean  « abstract »</text>
  <text x="482" y="415" font-size="10" fill="#555555" font-style="italic">+ displayResult() : void  « abstract »</text>

  <!-- ============================================================ -->
  <!-- INTERFACE: TwoPlayerGame -->
  <!-- ============================================================ -->
  <rect x="40" y="248" width="230" height="118" rx="4" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="2"/>
  <rect x="40" y="248" width="230" height="30" rx="4" fill="#6a1b9a"/>
  <text x="155" y="263" text-anchor="middle" font-size="11" fill="#ffffff" font-style="italic">« interface »</text>
  <text x="155" y="277" text-anchor="middle" font-size="13" font-weight="bold" fill="#ffffff">TwoPlayerGame</text>
  <line x1="40" y1="278" x2="270" y2="278" stroke="#6a1b9a" stroke-width="1.5"/>
  <text x="52" y="296" font-size="10" fill="#555555" font-style="italic">+ setPlayer2(String) : void</text>
  <text x="52" y="311" font-size="10" fill="#555555" font-style="italic">+ getPlayer2() : String</text>
  <text x="52" y="326" font-size="10" fill="#555555" font-style="italic">+ switchTurn() : void</text>
  <text x="52" y="341" font-size="10" fill="#555555" font-style="italic">+ getCurrentPlayer() : String</text>
  <text x="52" y="356" font-size="10" fill="#555555" font-style="italic">+ isPlayer2Turn() : boolean</text>

  <!-- ============================================================ -->
  <!-- SUBCLASSES — row of 6 -->
  <!-- ============================================================ -->

  <!-- GuessGame -->
  <rect x="38" y="530" width="190" height="162" rx="4" fill="#e8f5e9" stroke="#2e7d32" stroke-width="2"/>
  <rect x="38" y="530" width="190" height="28" rx="4" fill="#2e7d32"/>
  <text x="133" y="548" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">GuessGame</text>
  <line x1="38" y1="558" x2="228" y2="558" stroke="#2e7d32" stroke-width="1.2"/>
  <text x="50" y="572" font-size="10" fill="#555555">- int secretNumber</text>
  <text x="50" y="585" font-size="10" fill="#555555">- int maxAttempts</text>
  <text x="50" y="598" font-size="10" fill="#555555">- int attempts</text>
  <line x1="38" y1="605" x2="228" y2="605" stroke="#aaaaaa" stroke-width="1"/>
  <text x="50" y="619" font-size="10" fill="#2e7d32">+ play() : void</text>
  <text x="50" y="632" font-size="10" fill="#2e7d32">+ checkWin() : boolean</text>
  <text x="50" y="645" font-size="10" fill="#2e7d32">+ displayResult() : void</text>
  <text x="50" y="658" font-size="10" fill="#2e7d32">+ giveHint() : void</text>
  <text x="50" y="671" font-size="10" fill="#2e7d32">+ generateNumber() : int</text>
  <text x="50" y="684" font-size="10" fill="#2e7d32">+ showRules() : void</text>

  <!-- QuizGame -->
  <rect x="248" y="530" width="190" height="162" rx="4" fill="#fff8e1" stroke="#f57f17" stroke-width="2"/>
  <rect x="248" y="530" width="190" height="28" rx="4" fill="#f57f17"/>
  <text x="343" y="548" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">QuizGame</text>
  <line x1="248" y1="558" x2="438" y2="558" stroke="#f57f17" stroke-width="1.2"/>
  <text x="260" y="572" font-size="10" fill="#555555">- List&lt;Question&gt; questions</text>
  <text x="260" y="585" font-size="10" fill="#555555">- int score</text>
  <text x="260" y="598" font-size="10" fill="#555555">- int currentIndex</text>
  <line x1="248" y1="605" x2="438" y2="605" stroke="#aaaaaa" stroke-width="1"/>
  <text x="260" y="619" font-size="10" fill="#2e7d32">+ play() : void</text>
  <text x="260" y="632" font-size="10" fill="#2e7d32">+ checkWin() : boolean</text>
  <text x="260" y="645" font-size="10" fill="#2e7d32">+ displayResult() : void</text>
  <text x="260" y="658" font-size="10" fill="#2e7d32">+ loadQuestions() : void</text>
  <text x="260" y="671" font-size="10" fill="#2e7d32">+ askQuestion() : void</text>
  <text x="260" y="684" font-size="10" fill="#2e7d32">+ showRules() : void</text>

  <!-- MemoryMatch -->
  <rect x="458" y="530" width="190" height="162" rx="4" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="2"/>
  <rect x="458" y="530" width="190" height="28" rx="4" fill="#6a1b9a"/>
  <text x="553" y="548" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">MemoryMatch</text>
  <line x1="458" y1="558" x2="648" y2="558" stroke="#6a1b9a" stroke-width="1.2"/>
  <text x="470" y="572" font-size="10" fill="#555555">- String[] board</text>
  <text x="470" y="585" font-size="10" fill="#555555">- boolean[] revealed</text>
  <text x="470" y="598" font-size="10" fill="#555555">- int pairsFound</text>
  <line x1="458" y1="605" x2="648" y2="605" stroke="#aaaaaa" stroke-width="1"/>
  <text x="470" y="619" font-size="10" fill="#2e7d32">+ play() : void</text>
  <text x="470" y="632" font-size="10" fill="#2e7d32">+ checkWin() : boolean</text>
  <text x="470" y="645" font-size="10" fill="#2e7d32">+ displayResult() : void</text>
  <text x="470" y="658" font-size="10" fill="#2e7d32">+ flipCard(int) : void</text>
  <text x="470" y="671" font-size="10" fill="#2e7d32">+ isMatch(int,int) : boolean</text>
  <text x="470" y="684" font-size="10" fill="#2e7d32">+ showRules() : void</text>

  <!-- Minefield -->
  <rect x="668" y="530" width="190" height="162" rx="4" fill="#fce4ec" stroke="#c62828" stroke-width="2"/>
  <rect x="668" y="530" width="190" height="28" rx="4" fill="#c62828"/>
  <text x="763" y="548" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">Minefield</text>
  <line x1="668" y1="558" x2="858" y2="558" stroke="#c62828" stroke-width="1.2"/>
  <text x="680" y="572" font-size="10" fill="#555555">- boolean[] mines</text>
  <text x="680" y="585" font-size="10" fill="#555555">- boolean[] uncovered</text>
  <text x="680" y="598" font-size="10" fill="#555555">- int gridSize</text>
  <line x1="668" y1="605" x2="858" y2="605" stroke="#aaaaaa" stroke-width="1"/>
  <text x="680" y="619" font-size="10" fill="#2e7d32">+ play() : void</text>
  <text x="680" y="632" font-size="10" fill="#2e7d32">+ checkWin() : boolean</text>
  <text x="680" y="645" font-size="10" fill="#2e7d32">+ displayResult() : void</text>
  <text x="680" y="658" font-size="10" fill="#2e7d32">+ revealTile(int) : void</text>
  <text x="680" y="671" font-size="10" fill="#2e7d32">+ placeMines() : void</text>
  <text x="680" y="684" font-size="10" fill="#2e7d32">+ showRules() : void</text>

  <!-- RPSGame -->
  <rect x="878" y="530" width="190" height="175" rx="4" fill="#e0f7fa" stroke="#00838f" stroke-width="2"/>
  <rect x="878" y="530" width="190" height="28" rx="4" fill="#00838f"/>
  <text x="973" y="548" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">RPSGame</text>
  <text x="973" y="526" text-anchor="middle" font-size="9" fill="#006064" font-style="italic">implements TwoPlayerGame</text>
  <line x1="878" y1="558" x2="1068" y2="558" stroke="#00838f" stroke-width="1.2"/>
  <text x="890" y="572" font-size="10" fill="#555555">- String player2Name</text>
  <text x="890" y="585" font-size="10" fill="#555555">- boolean player2Turn</text>
  <text x="890" y="598" font-size="10" fill="#555555">- String[] choices</text>
  <line x1="878" y1="605" x2="1068" y2="605" stroke="#aaaaaa" stroke-width="1"/>
  <text x="890" y="619" font-size="10" fill="#2e7d32">+ play() : void</text>
  <text x="890" y="632" font-size="10" fill="#2e7d32">+ checkWin() : boolean</text>
  <text x="890" y="645" font-size="10" fill="#2e7d32">+ displayResult() : void</text>
  <text x="890" y="658" font-size="10" fill="#2e7d32">+ setPlayer2() : void</text>
  <text x="890" y="671" font-size="10" fill="#2e7d32">+ switchTurn() : void</text>
  <text x="890" y="684" font-size="10" fill="#2e7d32">+ cpuChoice() : String</text>
  <text x="890" y="697" font-size="10" fill="#2e7d32">+ showRules() : void</text>

  <!-- TicTacToe -->
  <rect x="1088" y="530" width="190" height="175" rx="4" fill="#e8eaf6" stroke="#283593" stroke-width="2"/>
  <rect x="1088" y="530" width="190" height="28" rx="4" fill="#283593"/>
  <text x="1183" y="548" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">TicTacToe</text>
  <text x="1183" y="526" text-anchor="middle" font-size="9" fill="#283593" font-style="italic">implements TwoPlayerGame</text>
  <line x1="1088" y1="558" x2="1278" y2="558" stroke="#283593" stroke-width="1.2"/>
  <text x="1100" y="572" font-size="10" fill="#555555">- char[] board</text>
  <text x="1100" y="585" font-size="10" fill="#555555">- String player2Name</text>
  <text x="1100" y="598" font-size="10" fill="#555555">- boolean player2Turn</text>
  <line x1="1088" y1="605" x2="1278" y2="605" stroke="#aaaaaa" stroke-width="1"/>
  <text x="1100" y="619" font-size="10" fill="#2e7d32">+ play() : void</text>
  <text x="1100" y="632" font-size="10" fill="#2e7d32">+ checkWin() : boolean</text>
  <text x="1100" y="645" font-size="10" fill="#2e7d32">+ displayResult() : void</text>
  <text x="1100" y="658" font-size="10" fill="#2e7d32">+ setPlayer2() : void</text>
  <text x="1100" y="671" font-size="10" fill="#2e7d32">+ switchTurn() : void</text>
  <text x="1100" y="684" font-size="10" fill="#2e7d32">+ makeMove(int) : void</text>
  <text x="1100" y="697" font-size="10" fill="#2e7d32">+ showRules() : void</text>

  <!-- ============================================================ -->
  <!-- HELPER CLASS: Question -->
  <!-- ============================================================ -->
  <rect x="248" y="760" width="190" height="135" rx="4" fill="#fffde7" stroke="#f9a825" stroke-width="1.8"/>
  <rect x="248" y="760" width="190" height="28" rx="4" fill="#f9a825"/>
  <text x="343" y="778" text-anchor="middle" font-size="12" font-weight="bold" fill="#ffffff">Question</text>
  <line x1="248" y1="788" x2="438" y2="788" stroke="#f9a825" stroke-width="1.2"/>
  <text x="260" y="803" font-size="10" fill="#555555">- String prompt</text>
  <text x="260" y="817" font-size="10" fill="#555555">- String[] options</text>
  <text x="260" y="831" font-size="10" fill="#555555">- char correctAnswer</text>
  <line x1="248" y1="838" x2="438" y2="838" stroke="#aaaaaa" stroke-width="1"/>
  <text x="260" y="852" font-size="10" fill="#2e7d32">+ getPrompt() : String</text>
  <text x="260" y="866" font-size="10" fill="#2e7d32">+ getOptions() : String[]</text>
  <text x="260" y="880" font-size="10" fill="#2e7d32">+ isCorrect(char) : boolean</text>

  <!-- ============================================================ -->
  <!-- RELATIONSHIPS / ARROWS -->
  <!-- ============================================================ -->

  <!-- ArcadeGameHub → Game (composition) -->
  <path d="M610,182 L610,248" fill="none" stroke="#111111" stroke-width="1.8" marker-start="url(#compose)" marker-end="url(#inherit)"/>
  <text x="618" y="220" font-size="10" fill="#555555">1..*</text>

  <!-- ArcadeGameHub label on line -->
  <rect x="626" y="207" width="72" height="15" rx="3" fill="#f0f0f0" stroke="#cccccc" stroke-width="1"/>
  <text x="662" y="219" text-anchor="middle" font-size="9" fill="#333333">has games</text>

  <!-- Game → each subclass (inheritance) -->
  <!-- to GuessGame -->
  <path d="M470,380 L133,530" fill="none" stroke="#111111" stroke-width="1.6" stroke-dasharray="1,0" marker-end="url(#inherit)"/>
  <!-- to QuizGame -->
  <path d="M510,426 L343,530" fill="none" stroke="#111111" stroke-width="1.6" marker-end="url(#inherit)"/>
  <!-- to MemoryMatch -->
  <path d="M570,426 L553,530" fill="none" stroke="#111111" stroke-width="1.6" marker-end="url(#inherit)"/>
  <!-- to Minefield -->
  <path d="M650,426 L763,530" fill="none" stroke="#111111" stroke-width="1.6" marker-end="url(#inherit)"/>
  <!-- to RPSGame -->
  <path d="M720,408 L973,530" fill="none" stroke="#111111" stroke-width="1.6" marker-end="url(#inherit)"/>
  <!-- to TicTacToe -->
  <path d="M760,390 L1183,530" fill="none" stroke="#111111" stroke-width="1.6" marker-end="url(#inherit)"/>

  <!-- TwoPlayerGame interface → RPSGame (implements dashed) -->
  <path d="M270,366 L878,580" fill="none" stroke="#6a1b9a" stroke-width="1.5" stroke-dasharray="7,4" marker-end="url(#assoc)"/>
  <!-- TwoPlayerGame interface → TicTacToe (implements dashed) -->
  <path d="M270,356 L1088,580" fill="none" stroke="#6a1b9a" stroke-width="1.5" stroke-dasharray="7,4" marker-end="url(#assoc)"/>

  <!-- Label on implements arrows -->
  <rect x="430" y="438" width="80" height="15" rx="3" fill="#f3e5f5" stroke="#6a1b9a" stroke-width="1"/>
  <text x="470" y="449" text-anchor="middle" font-size="9" fill="#6a1b9a">« implements »</text>

  <!-- QuizGame → Question (composition) -->
  <path d="M343,692 L343,760" fill="none" stroke="#111111" stroke-width="1.5" stroke-dasharray="5,3" marker-end="url(#assoc)"/>
  <text x="350" y="735" font-size="10" fill="#555555">uses</text>

  <!-- Inheritance label -->
  <rect x="570" y="466" width="82" height="15" rx="3" fill="#fff8e1" stroke="#f57f17" stroke-width="1"/>
  <text x="611" y="477" text-anchor="middle" font-size="9" fill="#f57f17">« extends »</text>

  <!-- ============================================================ -->
  <!-- OOP CONCEPT CALLOUTS -->
  <!-- ============================================================ -->
  <rect x="60" y="790" width="172" height="88" rx="6" fill="#f0fdf4" stroke="#16a34a" stroke-width="1.5"/>
  <text x="146" y="808" text-anchor="middle" font-size="11" font-weight="bold" fill="#16a34a">OOP Concepts Used</text>
  <text x="72" y="825" font-size="10" fill="#166534">▸ Abstraction  (Game class)</text>
  <text x="72" y="840" font-size="10" fill="#166534">▸ Inheritance  (extends Game)</text>
  <text x="72" y="855" font-size="10" fill="#166534">▸ Polymorphism (play())</text>
  <text x="72" y="870" font-size="10" fill="#166534">▸ Encapsulation (private fields)</text>

  <!-- Interface callout -->
  <rect x="60" y="888" width="172" height="54" rx="6" fill="#faf5ff" stroke="#7c3aed" stroke-width="1.5"/>
  <text x="146" y="906" text-anchor="middle" font-size="11" font-weight="bold" fill="#7c3aed">Interface</text>
  <text x="72" y="922" font-size="10" fill="#5b21b6">▸ TwoPlayerGame</text>
  <text x="72" y="936" font-size="10" fill="#5b21b6">  (RPS + TicTacToe)</text>

  <!-- Bottom line -->
  <line x1="60" y1="968" x2="1240" y2="968" stroke="#dddddd" stroke-width="1"/>
  <text x="650" y="984" text-anchor="middle" font-size="10" fill="#aaaaaa">ArcadeGameHub · Java OOP · Class Diagram</text>

</svg>

