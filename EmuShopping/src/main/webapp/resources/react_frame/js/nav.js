/**
 *
 * Created by litaoshen on 14/09/2015.
 */

var TabsExample = React.createClass({
  getInitialState: function () {
    return {
      tabs: [
        {id: "navbar_home", title: 'Home', content: 'Content 2', url: '/'},
        {
          id: "navbar_product",
          title: 'Products',
          content: 'Content 1',
          url: '/product/list'
        }
      ],
      active: $("[content]").attr("content")==="shoppingHome.jsp"? 0:1
    };
  },
  render: function () {
    return <div>
      <TabsSwitcher items={this.state.tabs} active={this.state.active}
                    onTabClick={this.handleTabClick}/>
    </div>;
  },

//<TabsContent items={this.state.tabs} active={this.state.active}/>

  handleTabClick: function (index) {
    this.setState({active: index})
  }
});

var TabsSwitcher = React.createClass({
  render: function () {
    var active = this.props.active;
    var items = this.props.items.map(function (item, index) {
      return <li key={item.id}
                 className={ item.id + ' ' + (active === index ? 'active' : '')}>
        <a href={item.url} onClick={this.onClick.bind(this, index)}>
          {item.title}
        </a></li>;
    }.bind(this));

    return <ul id="navbar_item" className={"nav navbar-nav"}>{items}</ul>;
  },
  onClick: function (index) {
    this.props.onTabClick(index);
  }
});

//var TabsContent = React.createClass({
//    render: function () {
//        var active = this.props.active;
//        var items = this.props.items.map(function (item, index) {
//            return $('#body').html()
//        });
//        return <div>{items}</div>;
//    }
//});

React.render(
  <TabsExample/>,
  document.getElementById("navbar_content")
);
