WHO=$(who am i | sed -e 's/ .*//');
mkdir -p ~/.gw;
mkdir -p /usr/local/games;
cp .gwconf ~/.gw;
cp gridworld.jar ~/.gw;
cp GridWorld /usr/local/games;
chown -R $WHO:$WHO ~/.gw;
